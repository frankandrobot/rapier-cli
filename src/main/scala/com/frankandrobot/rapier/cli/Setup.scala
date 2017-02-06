package com.frankandrobot.rapier.cli


object Setup {

  import Utils._

  val userDir = System.getProperty("user.dir")
  val rapierConfFilename = "rapier.conf"

  case class TrainingDataUri(val uri : String)
  case class LearnedRulesUri(val uri : String)
  case class DataUri(val uri : String)

  def setup() : Either[
    Throwable,
    (RapierConfJson, MasterTemplateJson, TrainingDataUri, LearnedRulesUri, DataUri)
    ] = {
    val result = for {
      rapierConfFullPath <- buildPath(userDir, rapierConfFilename)
      rapierConf <- loadFile[RapierConfJson](rapierConfFullPath)
      masterTemplateFullPath <- buildPath(userDir, rapierConf.masterTemplateUri)
      masterTemplate <- loadFile[MasterTemplateJson](masterTemplateFullPath)
      trainingDataUri <- buildPath(userDir, rapierConf.trainingDataUri)
      learnedRulesUri <- buildPath(userDir, rapierConf.learnedRulesUri)
      dataUri <- buildPath(userDir, rapierConf.dataUri)
    } yield (
      rapierConf,
      masterTemplate,
      TrainingDataUri(trainingDataUri),
      LearnedRulesUri(learnedRulesUri),
      DataUri(dataUri)
    )
    return result
  }
}
