## Gatling load tests

There are four packages demonstrating different things you can do with Gatling.

### github.basic

1. Execute some basic HTTP GET requests.

    sbt "test-only github.basic.GitHubSearchBasicSimulation"

### Local development - Login load test (must be done first to generate session tokens)

1. From terminal execute

    config=local.conf sbt "test-only basic.LoginLoadTest"

2. Login load test will run and each session token will get written to "md/thumper/src/test/resources/session_tokens.csv"

If you find it annoying that changes to session_tokens.csv show up every time you run LoginLoadTest, execute the
the following git command

    git update-index --assume-unchanged src/test/resources/session_tokens.csv

### Running other tests locally

    config=local.conf sbt "test-only package_name.test_class_name"

### How to set up Gatling on AWS

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

### Gatling gotchas
* Do not trust the Gatling documentation. The Google Group (http://bit.ly/1IjUZFz) and Stackoverlow are your friends.
* IP addresses, public & private
* Confirm services are actually deployed where you think they are
* Confirm correct ports for each service in nginx.conf
* If any nginx changes were made in stage/test environment, do a "sudo nginx -s reload"
* Database the deployed services are pointing to
* Change of user data: usernames & passwords in database compared to users.csv
* May need to restart a service
* Always reload nginx after making changes to its .conf file
* Security group problem?
* Be careful of missing dots in ScenarioBuilders. If dot missing, code compiles but Gatling throws
  UnsupportedOperationException. Example commit for fixed missing dot http://bit.ly/1FT2WXb
* Please add more gotchas to list as you uncover them. Your future self thanks you.


gatling-starter
===============

A skeleton project for performance testing of your web application

## Getting Started

- clone the repo

- run `./sbt test` to run existing test(s)

- run `./sbt startRecorder` to run the recorder

    - set the browser to use the proxy
    - record your user journeys

-

