package github.checker

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object GitHubSearchCheckerScenario {
  val searchesCsv = csv("searches.csv").random

  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub").feed(searchesCsv)
    .exec(GitHubSearchCheckerRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchCheckerRequester.searchForPages)
    .pause(1)
    .exec(GitHubSearchCheckerRequester.getGatlingPage)
}
