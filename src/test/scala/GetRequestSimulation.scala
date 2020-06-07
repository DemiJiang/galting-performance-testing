import io.gatling.core.Predef._
import io.gatling.http.Predef._



class GetRequestSimulation extends Simulation { // 3

  val httpProtocol = http // 4
    .baseUrl("examplesURL") // 5
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")


  val csvFeeder = csv("queryParameters.csv").circular
  val scn = scenario("GetRequestSimulation")
    .feed(csvFeeder)
    .exec(http("request_1")
      .get("/examples?gameId=${gameId}")
      .header(HttpHeaderNames.Accept, "*/*")
      .header(HttpHeaderNames.Authorization, s"Bearer token")
    )
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpProtocol)
}
