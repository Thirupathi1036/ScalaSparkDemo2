package com.org.spark.stack

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object Resta extends App {

  val spark = SparkSession.builder().master("local[2]").appName("Resta").getOrCreate()
  val fileName = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/stack/resta.csv"
  val df = spark.read.option("header", true).csv(fileName)


  val groupByCateWind = Window.partitionBy("Category", "Subcategory")

  val finalDf = df.withColumn("names", collect_list("Name").over(groupByCateWind))
    .withColumn("Subcategories", struct("Subcategory", "names"))
    .groupBy("Category").agg(collect_set("Subcategories") as "Subcategories")
    .toJSON
  finalDf.show()
}
