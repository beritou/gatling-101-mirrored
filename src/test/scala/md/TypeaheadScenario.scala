package basic

import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.core.structure.ScenarioBuilder

object TypeaheadScenario {

  val csvFeeder: RecordSeqFeederBuilder[String] = csv("/home/ubuntu/gatling/bin/session_tokens.csv").random

  val tas: ScenarioBuilder = scenario("Typeahead knee").feed(csvFeeder)
    .exec(TypeaheadRequester.typeahead)
}

