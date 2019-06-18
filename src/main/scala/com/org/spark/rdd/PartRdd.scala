package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object PartRdd  extends App {

  val spark=SparkSession.builder().appName("Part Test").master("local").getOrCreate()
  val sc=spark.sparkContext
  val fileName=getClass.getResource("/part_data/").getPath
  println(fileName)
  val wordsRdd=sc.textFile(fileName).map(w=> (w,1))
  wordsRdd.foreach(println)

  sc.parallelize(wordsRdd.top(10)) foreach(println)
}
