package github.checker

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object GitHubSearchCheckerScenario {

  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchCheckerRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchCheckerRequester.searchForGatling)
    .pause(1)
    .exec(GitHubSearchCheckerRequester.getGatlingPage)
}
