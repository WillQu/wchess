organization := "com.sfeir"

name := "wchess"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

seq(webSettings :_*)

libraryDependencies ++= {
  val liftVersion = "3.0.1"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910"  %
      "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" %
      "container,compile" artifacts Artifact("javax.servlet", "jar", "jar"),
    "org.neo4j" % "neo4j" % "3.0.6",
    "org.scalactic" %% "scalactic" % "3.0.0",
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    "org.apache.logging.log4j" % "log4j-core" % "2.7",
    "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.7"
    )
}

logBuffered in Test := false
