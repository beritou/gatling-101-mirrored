package github.checker

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GitHubSearchCheckerRequester {
   val getHomepage = http("github-home")
     .get("/")

   val searchForGatling = http("search-gatling").get("/search?utf8=✓&q=gatling")
//     .check(jsonPath("$.sessionId")
//       .saveAs("token"))
//     .check(status.is(200))

  val getGatlingPage = http("gatling-on-github")
    .get("/gatling/gatling")
 }
