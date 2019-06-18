package com.org.file

import org.apache.spark.sql.{Row, SparkSession}

import scala.util.parsing.json.JSONObject

object StrDemo extends App {

  def convertRowToJSON(row: Row): String = {
    val m = row.getValuesMap(row.schema.fieldNames)
    JSONObject(m).toString()
  }


  val spark = SparkSession.builder().appName("DF Demo").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext
  import sqlContext.implicits._

  val fileName = "C:/Thiru/Project/new_Project/payload.json"
  val empDf = spark.read.option("multiline", true).json(fileName)
  empDf.printSchema()
  empDf.show(10)
  empDf.rdd.map{ele=> convertRowToJSON(ele)}
    .toDF("names").show(2,false)
}
