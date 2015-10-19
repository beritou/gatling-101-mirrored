package github.checker

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GitHubSearchCheckerRequester {
   val getHomepage = http("github-home").get("/")
   val searchForPages = http("search-${uri}").get("/search?utf8=✓&q=${uri}")
   val getGatlingPage = http("gatling-on-github").get("/gatling/gatling")
 }
