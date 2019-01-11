package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object AccumulatorDemo extends App {

  val spark = SparkSession.builder().appName("Accumulator").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  //var numAcc = sc.accumulator(0)
  var numAcc = sc.longAccumulator("Name")

  val list = List("hai", "wel", "come", "hai", "spark", "hadoop", "spark", "hai", "hive")
  val strRdd = sc.parallelize(list).map { ele =>
    if (ele.equalsIgnoreCase("hai")) numAcc.add(2)
  }
  strRdd.collect()
  println(numAcc.value)
}
