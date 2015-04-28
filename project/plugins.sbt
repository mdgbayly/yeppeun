resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Heroku - Travis Integration

resolvers += "Bintray sbt plugin releases" at "http://dl.bintray.com/sbt/sbt-plugin-releases/"

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.6" excludeAll(ExclusionRule("org.bouncycastle", "*")))

addSbtPlugin("org.jruby" % "sbt-rubygems" % "1.2")

addSbtPlugin("com.heroku" % "sbt-heroku" % "0.3.7")

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.8")

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.0.0")




