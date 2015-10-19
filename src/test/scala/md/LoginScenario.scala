package basic

import io.gatling.core.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import io.gatling.core.structure.ScenarioBuilder
import scala.reflect.io.File
import io.gatling.core.session.Session

object LoginScenario {

  val csvFeeder: RecordSeqFeederBuilder[String] = csv("users.csv").random
  File("session_tokens.csv").writeAll("token" + sys.props("line.separator"))

  val login: ScenarioBuilder = scenario("Login and store session token").feed(csvFeeder)
    .exec(LoginRequester.login)
    .exec((s: Session) => {
      SessionTokenWriter.writeToken(s)
      s
     })
}
