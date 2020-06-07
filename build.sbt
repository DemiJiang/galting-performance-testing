ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.example"

lazy val root = (project in file(".")).
  enablePlugins(GatlingPlugin)
  .settings(
    inThisBuild(
      List(
        organization := "com.example",
        scalaVersion := "2.12.8",
        version := "0.1.0-SNAPSHOT"
      )
    ),

    name := "gatling-performance-test",

    libraryDependencies ++= Seq(
      "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1" % "test",
      "io.gatling"            % "gatling-test-framework"    % "3.3.1" % "test",
    )
  )

