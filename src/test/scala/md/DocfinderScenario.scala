package basic

import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.core.structure.ScenarioBuilder

object DocfinderScenario {

  val csvFeeder: RecordSeqFeederBuilder[String] = csv("/home/ubuntu/gatling/bin/session_tokens.csv")

  val search: ScenarioBuilder = scenario("Search for Bob").feed(csvFeeder)
    .exec(DocfinderRequester.search)
}
