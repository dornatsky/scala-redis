import sbt._
import Keys._

object ScalaRedisProject extends Build
{
  import Resolvers._
  lazy val root = Project("RedisClient", file(".")) settings(coreSettings : _*)

  lazy val commonSettings: Seq[Setting[_]] = Seq(
    organization := "net.debasishg",
    version := "2.7-reconnect",
    scalaVersion := "2.9.2",
    scalacOptions ++= Seq("-deprecation", "-unchecked"),
    resolvers ++= Seq(twitterRepo)
  )

  lazy val coreSettings = commonSettings ++ Seq(
    name := "RedisClient",

    libraryDependencies ++= Seq("commons-pool" % "commons-pool" % "1.6",
      "org.slf4j"      % "slf4j-api"     % "1.6.6",
      "org.slf4j"      % "slf4j-log4j12" % "1.6.6"  % "provided",
      "log4j"          % "log4j"         % "1.2.16" % "provided",
      "junit"          % "junit"         % "4.8.1"  % "test",
      "org.scalatest"  % "scalatest_2.9.1" % "1.6.1" % "test",
      "com.twitter"    % "util_2.9.1"    % "1.12.13" % "test" intransitive(),
      "com.twitter"    % "finagle-core_2.9.1"  % "4.0.2" % "test"),

    parallelExecution in Test := false)
}

object Resolvers {
  val twitterRepo = "release" at "http://maven.twttr.com"
}
