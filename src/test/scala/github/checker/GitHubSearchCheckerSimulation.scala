package github.checker

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.config.HttpProtocolBuilder

import scala.concurrent.duration._

class GitHubSearchCheckerSimulation extends Simulation {
    val gitHubProtocol: HttpProtocolBuilder = http
      .baseURL("https://api.github.com")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .acceptEncodingHeader( "gzip, deflate")
      .acceptLanguageHeader( "en-US,en;q=0.5")
      .connection( "keep-alive")
      .doNotTrackHeader( "1")
      .userAgentHeader( "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:32.0) Gecko/20100101 Firefox/32.0")

    setUp(
      GitHubSearchCheckerScenario.search.inject(
        nothingFor(1 second),
        atOnceUsers(1),
        rampUsers(5) over(5 seconds)
      )
    ).protocols(gitHubProtocol)
  }
