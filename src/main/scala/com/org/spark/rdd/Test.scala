package com.org.spark.rdd

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object Test extends App {

  val spark=SparkSession.builder().appName("Test").master("local").getOrCreate()
  import spark.sqlContext.implicits._
  val raw = spark.sparkContext.parallelize(Seq(
    ("5:00 PM","523" ,"384" ,"40"),
    ("6:00 PM","384","60","nan")))
    .toDF("Timestamp", "a", "b","c")

  // drop timestamp column
  val data = raw.drop("Timestamp")

  data.show()
}
