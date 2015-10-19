## Gatling load tests

There are four packages demonstrating different things you can do with Gatling.

### github.basic

Execute some basic HTTP GET requests.

    sbt "test-only github.basic.GitHubSearchBasicSimulation"

### github.feeder

Read from external data source (in this case a CSV), inject this data into the HTTP GET requests.

    sbt "test-only github.feeder.GitHubSearchFeederSimulation"

### github.checker

Extract data from HTTP responses, store them in a variable, pass them along to a subsequent HTTP GET request.

    sbt "test-only github.checker.GitHubSearchCheckerSimulation"

### github.extra

For when you want to write some plain old Scala outside the confines of the Gatling DSL.

    sbt "test-only github.extra.GitHubSearchExtraSimulation"

## A word of warning
* Do not trust the official Gatling documentation. It is incorrect and/or out-of-date in several places. The Google Group (http://bit.ly/1IjUZFz) and Stackoverlow are your friends.

## How to set up Gatling on AWS

1. Create fresh Ubuntu instance on AWS. m4.2xlarge has been used in the past and works well. Might be able to get away with something smaller/cheaper.

2. ssh into instance just created

3. Execute the following commands:

  * sudo apt-get update
  * sudo apt-get install scala
  * wget "https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/2.1.7/gatling-charts-highcharts-bundle-2.1.7-bundle.zip"
  * sudo apt-get install unzip
  * unzip gatling-charts-highcharts-bundle-2.1.7-bundle.zip
  * rm gatling-charts-highcharts-bundle-2.1.7-bundle.zip
  * mv gatling-charts-highcharts-bundle-2.1.7 gatling
  * cd /home/ubuntu/gatling/user-files/simulations
  * mkdir basic

4. Disconnect from the Gatling Ubuntu box

5. On laptop, if not done already, clone thumper repository & checkout develop branch

6. Copy CSV file containing usernames/passwords to newly-created Ubuntu Gatling box by executing the following: scp -i full_path_to_pem_file thumper/src/test/resources/users.csv ubuntu@gatling_machine_ip_address:/home/ubuntu/gatling/bin. Note that the users.csv file must be located in /home/ubuntu/gatling/bin.

7. Copy load tests to newly-created Ubuntu Gatling box by executing the following: scp -i full_path_to_pem_file thumper/src/test/scala/basic/* ubuntu@gatling_machine_ip_address:/home/ubuntu/gatling/user-files/simulations/basic

8. To actually run the load tests, ssh back into the Ubuntu Gatling box and execute the following: /home/ubuntu/gatling/bin/gatling.sh

9. Gatling will present a list of simulations. Pick one to run it. Note: in most cases you will need to first run LoginSimulation to generate session tokens. LoginSimulation will write these session tokens to /home/ubuntu/gatling/bin/session_tokens.csv. The multi-step LoginTypeaheadDocfinderSimulation does not write session tokens to disk, they get re-used in-memory.
