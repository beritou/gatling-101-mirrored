package basic

import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.core.structure.ScenarioBuilder

object LoginTypeaheadDocfinderScenario {

  val csvFeeder: RecordSeqFeederBuilder[String] = csv("users.csv").random

  val go: ScenarioBuilder = scenario("Login, typeahead for knee, then docfinder search").feed(csvFeeder)
    .exec(LoginRequester.login)
    .exec(TypeaheadRequester.typeahead)
    .exec(DocfinderRequester.search)
}