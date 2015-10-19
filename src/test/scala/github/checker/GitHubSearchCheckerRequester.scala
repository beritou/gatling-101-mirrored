package github.checker

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GitHubSearchCheckerRequester {
   val getHomepage = http("github-home")
     .get("/")

   val searchForGatling = http("search-gatling")
     .get("/search/repositories?q=gatling")
     .check(jsonPath("$.items[0].name")
       .saveAs("resultName"))
     .check(status.is(200))

  val searchForGatlingWithStoredSessionVariable = http("search-gatling-with-session-variable")
    .get("/search/repositories?q=${resultName}")
     .check(jsonPath("$.items[0].name")
       .saveAs("resultName"))
     .check(status.is(200))
 }
