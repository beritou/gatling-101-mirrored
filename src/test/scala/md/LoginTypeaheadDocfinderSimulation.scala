package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LoginTypeaheadDocfinderSimulation extends Simulation {

  val AWSHttpConf = http.baseURL("https://employer-dev.mdinsider.com")

//  setUp(
//    LoginTypeaheadDocfinderScenario.go.inject(
//      rampUsers(6000) over (30 seconds))
//      .protocols(AWSHttpConf)
//  )
}