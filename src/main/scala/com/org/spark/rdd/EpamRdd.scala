package com.org.spark.rdd

import scala.util.parsing.json._
import org.apache.spark.sql.SparkSession

object EpamRdd extends App {

  val spark = SparkSession.builder().appName("Epam Test").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val fileName = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/epam.json"

  val rdd = sc.textFile(fileName)

  val jsonRdd = rdd.map(x => JSON.parseFull(x)).map(x => x.get.asInstanceOf[Map[String, String]])
    .map(y => (y("id"), y("text").split("#").map(x => x.trim).toSeq.filter(!_.equals(""))))
  println(jsonRdd.collect().toList)

  val countRdd = jsonRdd.map(x => x._2.map(y => (y, 1))).flatMap(x => x).reduceByKey((a, b) => a + b)
  println(countRdd.collect().toSeq)


}
