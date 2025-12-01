import sbt._
object Dependencies {
  private lazy val scalaTestVersion = "3.2.18"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
}