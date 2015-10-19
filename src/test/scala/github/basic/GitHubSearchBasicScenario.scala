package github.basic

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object GitHubSearchBasicScenario {
  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchBasicRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchBasicRequester.searchForGatling)
    .pause(1)
    .exec(GitHubSearchBasicRequester.getGatlingPage)
}
