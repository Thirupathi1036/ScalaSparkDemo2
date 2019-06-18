package com.org.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object EmptyRdd extends App {

  val spark = SparkSession.builder().appName("Accumulator").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext
  val list = List("hai", "wel", "come", "hai", "spark", "hadoop", "spark", "hai", "hive")
  //val wordsRdd = sc.parallelize(list)
  val emptRdd: RDD[String] = null
 // println(emptRdd.isEmpty())
  val aa=sc.longAccumulator
  val wordsRdd=sc.parallelize(list).map{word=>
    if(word.equalsIgnoreCase("hai")) aa.add(1)
  }
  println(wordsRdd.count())
  println(aa.value)


}
