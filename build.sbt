name := """yeppeun"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

herokuAppName in Compile := "shrouded-springs-5377"

// Heroku - Travis integration
resolvers += "rubygems-release" at "http://rubygems-proxy.torquebox.org/releases"

libraryDependencies ++= Seq(
  "rubygems" % "travis" % "1.7.6" excludeAll(ExclusionRule("rubygems", "pry", "*"), ExclusionRule("rubygems", "ffi", "*")),
  "rubygems" % "pry" % "0.9.12.6",
  "rubygems" % "ffi" % "1.9.3"
)