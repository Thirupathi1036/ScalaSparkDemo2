package com.org.file

import java.io.{File, PrintWriter}

import org.apache.spark.sql.{Row, SparkSession}

import scala.io.Source
import scala.util.parsing.json.JSONObject
import org.apache.spark.sql.functions._
object ColumnNames extends App {

 /* val convertJson=udf{convertRowToJSON(row:Row):String=>{
    val m = row.getValuesMap(row.schema.fieldNames)
    JSONObject(m).toString()
  }}*/

  def convertRowToJSON(row: Row): String = {
    val m = row.getValuesMap(row.schema.fieldNames)
    JSONObject(m).toString()
  }


  val spark = SparkSession.builder().appName("DF Demo").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext
  import sqlContext.implicits._

  val fileName = "C:/Thiru/Project/new_Project/payload.json"
  val outFileName = "C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\output\\columns.txt"
  //val file = new File(outFileName)
  //val writer = new PrintWriter(file)
  val empDf = spark.read.option("multiline", true).json(fileName)
  empDf.printSchema()
  empDf.show(10)
  empDf.rdd.map{ele=> convertRowToJSON(ele)}
    .toDF("names").show(2,false)
  //empDf.write.jdbc("C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\output\\json\\")
  //val str = empDf.schema.treeString
  //writer.write(str)
  //writer.close()
  //val builder = new StringBuilder()
  //var parent = ""
  //val columnList = Source.fromFile(outFileName).getLines().filter(ele => !ele.contains("element:") && !ele.contains("root"))
  // .map { ele => ele.split("\\|", 2)(1).split(":")(0) }.toList
  //.map { ele => parseString(ele) }
  /*.map {ele =>ele.split(":")(0).trim.replaceAll("\\|-- ", "")
         .replaceAll("\\|  ", "")}.toList*/
  // println(columnList.size)
  /*
    val res = ""
    val addSpace = "    |"
    builder.clear()
    for (i <- 0 to columnList.length - 1) {
      var ppp = ""
      for (j <- i to columnList.length - 1) {
        if (columnList(j).startsWith("--")) {
          val innChild = columnList(j).split("--")(1).trim
          println("In cHild: " + innChild)
          builder.append(innChild + "\n")
        } else {
          ppp = columnList(i)
          println(columnList(j))
          println(ppp)
        }
      }
    }


    def parseString(str: String, inParent: String = ""): Unit = {
      if (str.startsWith("--")) {
        val child = str.split(" ")(1).trim
        parent = child
        builder.append(inParent + "." + child + "\n")
      } else {
        val inStrArray = str.split("\\|")
        val child = inStrArray(inStrArray.length - 1)
        parseString(child, parent)
      }
    }

    println(builder.toString())*/
  //val modifiedStr = columnList.mkString("\n")
  //val newWriter = new PrintWriter(file)
  //newWriter.write(modifiedStr)
  //newWriter.close()
}
