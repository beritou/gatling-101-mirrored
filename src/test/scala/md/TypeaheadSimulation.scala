package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class TypeaheadSimulation extends Simulation {

  val AWSHttpConf = http.baseURL("https://employer-dev.mdinsider.com")

//  setUp(
//    TypeaheadScenario.tas.inject(
//      rampUsers(500) over (10 seconds))
//        .protocols(AWSHttpConf)
//  )
}