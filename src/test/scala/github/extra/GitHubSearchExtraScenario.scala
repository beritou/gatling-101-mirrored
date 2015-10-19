package github.extra

import java.util.Calendar

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

object GitHubSearchExtraScenario {
  val search: ScenarioBuilder = scenario("Search for Gatling on GitHub")
    .exec(GitHubSearchExtraRequester.getHomepage)
    .pause(2)
    .exec(GitHubSearchExtraRequester.searchForGatling)
    .pause(1)
    .exec(GitHubSearchExtraRequester.getGatlingPage)
    .exec((s: Session) => {
      sideEffectAllTheThings()
      s
     })

  def sideEffectAllTheThings(): Unit = {
    println("Time flies when you're Gatling-ing! The current time is "
      + Calendar.getInstance().getTime() )
  }
}
