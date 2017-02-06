package com.frankandrobot.rapier.cli

import scala.collection.immutable.HashMap

sealed trait JsonConf

case class RapierConfJson(val params : RapierParamsJson,
                          val masterTemplateUri : String,
                          val trainingDataUri : String,
                          val learedRulesUri: String,
                          val dataUri: String)
  extends JsonConf

case class RapierParamsJson(val maxOuterLoopFails: Option[Int],
                            val compressionRandomPairs: Option[Int],
                            val compressionPriorityQueueSize: Option[Int],
                            val compressionFails: Option[Int],
                            val metricMinPositiveMatches: Option[Int],
                            val maxElementsToSpecialize: Option[Int],
                            val ruleSizeWeight: Option[Double],
                            val maxPatternLength: Option[Int],
                            val maxUnequalPatternLength: Option[Int],
                            val maxDifferenceInPatternLength: Option[Int])
  extends JsonConf

case class MasterTemplateJson(val name : String, val slots : List[String])
  extends JsonConf

case class TrainingExampleJson(val document : String,
                               val filledTemplate: HashMap[String, List[String]])
  extends JsonConf
