scalaVersion := "2.11.7"

name := "Integter Literal Parser"

libraryDependencies ++= Seq("com.lihaoyi" %% "acyclic" % "0.1.3",
			    "com.lihaoyi" %% "fastparse" % "0.3.4")
// for debugging sbt problems
logLevel := Level.Debug
