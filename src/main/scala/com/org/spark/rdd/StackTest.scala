package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object StackTest extends App {

  val spark = SparkSession.builder().appName("Test Emp").master("local").getOrCreate()
  val sc = spark.sparkContext

  val fileName = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/stack/stact_test.txt"
  val strRdd = sc.textFile(fileName).map { line =>
    val data = line.split(",")
    (data(0), data(1), data(3))
  }.filter(rec=>rec._3.toLowerCase.trim.equals("hyd"))

  strRdd foreach println

}
