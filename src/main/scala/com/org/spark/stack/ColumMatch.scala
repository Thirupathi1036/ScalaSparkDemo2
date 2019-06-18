package com.org.spark.stack

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object ColumMatch extends App {

  val spark = SparkSession.builder().appName("Test Emp").master("local").getOrCreate()

  import spark.implicits._
  val df1 = spark.read.format("csv").option("wholeFile", true).option("multiline", true).option("inferSchema", "true").option("header", true).option("escape", "\"").csv("/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/stack/sample1.csv")
  val df2 = spark.read.format("csv").option("wholeFile", true).option("multiline", true).option("inferSchema", "true").option("header", true).option("escape", "\"").csv("/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/stack/sample2.csv")

  val cols = df1.columns.map(e=>col(e))

  df1.union(df2.select(cols:_*))

  val details = Seq(
    (1, "1-1-19", "blr", 30),
    (2, "1-2-18", "up", 33),
    (3, "1-2-18", "dlh", 25)
  ).toDF("code", "date", "location", "temperature")

  val refrenceDetails = Seq(
    (1, "1-1-19", "blr"),
    (2, "1-2-18", "up")).
    toDF("code", "date", "location")

  val dd=details.intersect(refrenceDetails)
  dd.show()
}
