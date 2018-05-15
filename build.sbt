// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.6"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.2"
//libraryDependencies += "com.definitelyscala" %%% "scala-js-topojson" % "1.1.0"

scalaJSUseMainModuleInitializer := true
mainClass := Some("example.ScalaJSExample_test")


npmDependencies in Compile ++= (
  "d3" -> "4.12.2" ::
    "topojson-client" -> "3.0.0" ::
    Nil
  )

useYarn := true

scalacOptions ++=
  "-encoding" :: "UTF-8" ::
    "-unchecked" ::
    "-deprecation" ::
    "-explaintypes" ::
    "-feature" ::
    "-language:_" ::
    // "-Xlint:_" ::
    // "-Ywarn-unused" ::
    "-P:scalajs:sjsDefinedByDefault" ::
    Nil