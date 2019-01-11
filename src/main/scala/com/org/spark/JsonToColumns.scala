package com.org.spark

import com.fasterxml.jackson.databind.ObjectMapper

import java.io._

import javax.json.JsonException
import org.json.simple.parser.JSONParser
import org.json.simple.{JSONArray, JSONObject}
import org.json._

import scala.collection.JavaConversions._
import scala.io.Source

object JsonToColumns extends App {

  val recordSet = scala.collection.mutable.Set.empty[String]
  val columnsFileName = "C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\output\\JsonCol.txt"
  try {
    val parser: JSONParser = new JSONParser
    val fileReader=new FileReader("C:/Thiru/Project/new_Project/payload.json")

    val obj = parser.parse(fileReader)
    //val file = "C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\input\\emp.json"
    /*val payloadFile = Source.fromFile(file).getLines().toList.map { ele =>
      if (ele.trim.startsWith("\uFEFF")) ele.trim.substring(1) else ele.trim
    }*/
    //payloadFile.map { jsonStr => printJsonKeys(parser.parse(jsonStr), "") }


    println("--------procesing Json to get attributes-------")
    recordSet foreach (println)
    printJsonKeys(obj, "")
    println(recordSet.size) // foreach (println)
    val newList = recordSet.map { rec =>
      if (rec.startsWith("_")) rec.replace("_", ".")
      else rec.replaceAll("[\\^_\\.]+", ".")
    }
    println(s"Writing column names to $columnsFileName ")
    val writer = new PrintWriter(new File(columnsFileName))
    newList.map(col => writer.write(col))
    writer.close()
    println(s"$columnsFileName created with all Columns")
    println("------------- done ----------------")
  } catch {
    case fe: FileNotFoundException => fe.printStackTrace()
  }


  def printJsonArrayKeys(obj: Any, parentPath: String): Unit = {
    val arrayObj = obj.asInstanceOf[JSONArray]

    for (i <- 0 until arrayObj.size()) {
      val jo = arrayObj.get(i)
      jo match {
        case jsonObject: JSONObject => printJsonKeys(jsonObject, parentPath)
        case _ =>
      }
      printJsonKeys(jo, parentPath)
    }
  }

  def printJsonKeys(obj: Any, parentPath: String) {
    val jsonObject: JSONObject = obj match {
      case jsonObject: JSONObject => obj.asInstanceOf[JSONObject]
      case _ => new JSONObject()
    }
    try {
      jsonObject.keySet().map { key =>
        val keyValue = jsonObject.get(key.toString)

        keyValue match {
          case jsonObject: JSONObject =>
            printJsonKeys(jsonObject, if (parentPath.isEmpty) key.toString
            else parentPath + "." + key.toString)
          case jsonArray: JSONArray =>
            printJsonArrayKeys(jsonArray, if (parentPath.isEmpty) key.toString
            else parentPath + "." + key.toString)
          case _ =>
        }
        recordSet.add((parentPath + "_" + key).trim)
      }
    } catch {
      case ex: Exception => ex.printStackTrace()
    }
  }

}
