package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object LoginRequester {
  val login: HttpRequestBuilder = http("login")
      .post("/v1/auth/login")
      .formParam("uid", "${username}")
      .formParam("pwd", "${password}")
      .header("X-CID", "${cid}")
      .check(jsonPath("$.sessionId").saveAs("token"))
      .check(status.is(200))
}
