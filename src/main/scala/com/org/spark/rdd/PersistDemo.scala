package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object PersistDemo extends App {

  val spark = SparkSession.builder().appName("Test").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val list = List(1, 2, 3, 4)
  val numRdd = sc.parallelize(list)
  val header=numRdd.first()
  numRdd.saveAsTextFile("")

}
