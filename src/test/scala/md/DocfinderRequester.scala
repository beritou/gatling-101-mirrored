package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object DocfinderRequester {
  val search: HttpRequestBuilder = http("providers")
    .get("/v1/providers")
    .queryParam("pageNumber", 1)
    .queryParam("pageSize", 10)
    .queryParam("searchCode", "bob")
    .queryParam("distance", "25")
    .queryParam("userLat", "34.01932907104492")
    .queryParam("userLng", "-118.49434661865234")
    .queryParam("searchType", "NM")
    .header("Authorization", "${token}")
}
