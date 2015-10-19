package github.feeder

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object GitHubSearchFeederScenario {
  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchFeederRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchFeederRequester.searchForGatling)
    .pause(1)
    .exec(GitHubSearchFeederRequester.getGatlingPage)
}

object GitHubSearchFeederRequester {
  val getHomepage = http("github-home").get("/")
  val searchForGatling = http("search-gatling").get("/search?utf8=✓&q=gatling")
  val getGatlingPage = http("gatling-on-github").get("/gatling/gatling")
}
