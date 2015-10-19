package github.checker

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import scala.concurrent.duration._

object GitHubSearchCheckerScenario {

  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchCheckerRequester.searchForGatling)
    .pause(5 seconds)
    .exec(GitHubSearchCheckerRequester.searchForGatlingWithStoredSessionVariable)
}
