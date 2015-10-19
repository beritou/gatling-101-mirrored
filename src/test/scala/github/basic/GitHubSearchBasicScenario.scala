package github.basic

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

object GitHubSearchBasicScenario {
  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchBasicRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchBasicRequester.searchForGatling)
    .pause(1)
    .exec(GitHubSearchBasicRequester.getGatlingPage)
}

object GitHubSearchBasicRequester {
  val getHomepage = http("github-home").get("/")
  val searchForGatling = http("search-gatling").get("/search?utf8=✓&q=gatling")
  val getGatlingPage = http("gatling-on-github").get("/gatling/gatling")
}
