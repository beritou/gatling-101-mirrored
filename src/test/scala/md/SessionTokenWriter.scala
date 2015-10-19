package basic

import scala.reflect.io.File
import io.gatling.core.session.Session

object SessionTokenWriter {

  val SESSION_TOKENS_PATH_FOR_RUNNING_IN_AWS = "/home/ubuntu/gatling/bin/session_tokens.csv"
  val SESSION_TOKENS_PATH_FOR_RUNNING_LOCALLY = "session_tokens.csv"

  def writeToken(s: Session): Unit =
    File(SESSION_TOKENS_PATH_FOR_RUNNING_IN_AWS)
      .appendAll(s"${s("token").as[String]}" + sys.props("line.separator"))
}
