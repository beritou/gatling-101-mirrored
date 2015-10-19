package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object TypeaheadRequester {
  val typeahead: HttpRequestBuilder = http("tas")
        .get("/v1/tas")
        .queryParam("key", "knee")
        .header("Authorization", "${token}")
        .header("Content-Type", "application/json")
        .check(status.is(200))
}
