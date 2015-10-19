package github

import io.gatling.core.structure.ScenarioBuilder
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GitHubSearchScenario {
  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchRequester.getHomepage)
    .pause(2)
    .exec(http("search-gatling").get("/search?utf8=✓&q=gatling"))
    .pause(1)
    .exec(http("gatling-on-github").get("/gatling/gatling"))
}

object GitHubSearchRequester {
  val getHomepage = http("github-home").get("/")
}
