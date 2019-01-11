package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object WordCount extends App {

  val spark = SparkSession.builder().appName("Test Df").master("local").getOrCreate()
  val sc = spark.sparkContext
  val strList = "hi hello spark is good hadoop hello bang spark hadoop scala java spark".split(" ")
  val strRdd = sc.parallelize(strList)
  val mapRdd = strRdd.map(w => (w, 1))
  val reduceRdd = mapRdd.reduceByKey(_ + _)
  println(reduceRdd.toDebugString)
}
