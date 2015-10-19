package github.extra

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GitHubSearchExtraRequester {
   val getHomepage = http("github-home").get("/")
   val searchForGatling = http("search-gatling").get("/search?utf8=✓&q=gatling")
   val getGatlingPage = http("gatling-on-github").get("/gatling/gatling")
 }
