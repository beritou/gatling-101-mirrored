package github.feeder

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object GitHubSearchFeederScenario {
  val searchesCsv = csv("searches.csv").random

  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub").feed(searchesCsv)
    .exec(GitHubSearchFeederRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchFeederRequester.searchForPages)
    .pause(1)
    .exec(GitHubSearchFeederRequester.getGatlingPage)
}
