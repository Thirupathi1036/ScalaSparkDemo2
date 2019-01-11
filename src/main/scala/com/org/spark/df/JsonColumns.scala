package com.org.spark.df

import org.json4s._
import org.json4s.jackson.JsonMethods._
import java.io.{File, PrintWriter}

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._

import scala.collection.mutable.ListBuffer

object JsonColumns extends App {

  val spark = SparkSession.builder().appName("DF Demo").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  //val fileName = "C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\input\\emp.json"
  val fileName = "C:/Thiru/Project/new_Project/payload.json"
  val outFileName = "C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\output\\columns.txt"
  val writer =new PrintWriter(new File(outFileName))
  val empDf = spark.read.option("multiline", true).json(fileName)
  //empDf.show()
  //val str = empDf.printSchema().toString
  empDf.printSchema()
  val str=empDf.schema.treeString
  writer.write(str)
  writer.close()
  val jsonString = empDf.schema.json
  val builder = new StringBuilder

  //parseJson(jsonString)

  def parseJson(jsonStr: String) = {
    implicit val formats = org.json4s.DefaultFormats

    val jsonMap = parse(jsonStr).extract[Map[String, Any]]
    val data = jsonMap("fields")
    //println(data)
    val listData = data.asInstanceOf[List[Map[String, Any]]]
    listData.map { ele =>
      val inMap = removeData(ele)
      println(inMap)
      //parseColumns(builder, inMap)
    }
  }

  def removeData(map: Map[String, Any]) = map.filter(ele => !ele._1.equalsIgnoreCase("metadata") && !ele._1.equalsIgnoreCase("nullable"))

  /*def parseColumns(builder: StringBuilder, jsonMap: Map[String, Any]) = {
    val dataType = jsonMap("type")
    dataType match {
      case "string" => builder.append(jsonMap("name") + "\n")
      case jMap: Map[String, Any] => parseMap(jsonMap("name").toString, jMap, builder)
      case _ => builder.append(jsonMap("name") + "\n")
    }
  }*/

 /* def parseMap(key: String, inMap: Map[String, Any], builder: StringBuilder): Unit = {
    if (inMap.contains("elementType")) {
      val innerMap = inMap("elementType").asInstanceOf[Map[String, Any]]
      parseMap(key, innerMap, builder)
    }
    if (inMap.contains("fields")) {
      val fList = inMap("fields").asInstanceOf[List[Map[String, Any]]]
      val keyList = fList.map { ele => key + "." + ele("name") }
      builder.append(keyList.mkString("\n") + "\n")
    }
  }*/

  println(builder.toString())
}