package com.org.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object NumRdd extends App {

  val spark = SparkSession.builder().appName("Number Rdd").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  def intToString(num: Int) = num.toString + "*"


  val list = List(1, 2, 3, 4, 5)

  val numRdd: RDD[Int] = sc.parallelize(list)

  val strRdd=numRdd.map(intToString)
  strRdd.foreach(println)

}
