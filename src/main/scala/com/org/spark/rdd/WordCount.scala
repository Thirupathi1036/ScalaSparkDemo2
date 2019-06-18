package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object WordCount extends App {

  val spark = SparkSession.builder().appName("Test Df").master("local").getOrCreate()
  val sc = spark.sparkContext
  val strList = List("hi hello spark", "is good hadoop", "hello bang spark hadoop", "scala java spark")
  val strRdd = sc.parallelize(strList).flatMap(line=>line.split(" "))
  val mapRdd = strRdd.map(w => (w, 1))
  val reduceRdd = mapRdd.reduceByKey((a,b)=> a + b)
  println(reduceRdd.toDebugString)
  val res_smaple=reduceRdd.repartition(100).persist()
  println("=================")
  res_smaple.foreach(println)

  val words=strList.flatMap(line=>line.split(" ")).sortBy(w=>w.length).last

  println(words)

}
