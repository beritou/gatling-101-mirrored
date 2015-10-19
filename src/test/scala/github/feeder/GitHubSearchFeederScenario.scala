package github.feeder

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object GitHubSearchFeederScenario {
  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchFeederRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchFeederRequester.searchForGatling)
    .pause(1)
    .exec(GitHubSearchFeederRequester.getGatlingPage)
}
