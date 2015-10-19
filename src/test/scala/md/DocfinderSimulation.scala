package basic

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class DocfinderSimulation extends Simulation {

  val AWSHttpConf = http.baseURL("https://employer-dev.mdinsider.com")

//  setUp(
//    DocfinderScenario.search.inject(
//      rampUsers(599) over (30 seconds))
//      .protocols(AWSHttpConf)
//  )
}
