import AssemblyKeys._

Nice.javaProject

javaVersion := "1.8"

fatArtifactSettings

organization := "bio4j"

name := "titandb"

description := "titandb implementation of the Bio4j model"

bucketSuffix := "era7.com"


libraryDependencies ++= Seq(
  "bio4j" % "bio4j" % "0.12.0-SNAPSHOT",
  "ohnosequences" % "typed-graphs" % "0.1.0-SNAPSHOT",
  "ohnosequences" % "bioinfo-util" % "1.3.0",
  "com.thinkaurelius.titan" % "titan-berkeleyje" % "0.4.4",
  "com.tinkerpop.blueprints" % "blueprints-core" % "2.4.0",
  "junit" % "junit" % "3.8.1" % "test"
)

dependencyOverrides ++= Set(
  "commons-codec" % "commons-codec" % "1.7",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.1.2",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.1.2",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.1.1",
  "commons-beanutils" % "commons-beanutils" % "1.8.3",
  "commons-beanutils" % "commons-beanutils-core" % "1.8.3"
)


// fat jar assembly settings
mainClass in assembly := Some("com.era7.bioinfo.bio4j.titan.program.ImportTitanDB")

assemblyOption in assembly ~= { _.copy(includeScala = false) }

mergeStrategy in assembly ~= { old => {
    case PathList("META-INF", "CHANGES.txt")                      => MergeStrategy.rename
    case PathList("META-INF", "LICENSES.txt")                     => MergeStrategy.rename
    case "log4j.properties"                                       => MergeStrategy.filterDistinctLines
    case PathList("org", "apache", "commons", "collections", _*)  => MergeStrategy.first
    case x                                                        => old(x)
  }
}