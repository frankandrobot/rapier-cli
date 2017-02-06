package com.frankandrobot.rapier.cli

import java.nio.file.{Files, Paths}
import io.circe.generic.auto._
import io.circe.parser._
import scala.io.Source


object Utils {

  def buildPath(basePath : String, path : String) = {
    val _path =
      if (Paths.get(path).isAbsolute) path
      else s"${basePath}/${path}"
    if (Files.exists(Paths.get(_path))) Right(_path)
    else Left(new Error(s"${_path} does not exist"))
  }

  def loadFile[T](path : String) = {
    val file = Source.fromFile(path, "utf-8").mkString

    decode[T](file)
  }
}
