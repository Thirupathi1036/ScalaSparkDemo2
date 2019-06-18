package com.org.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object ReduceByKeyDemo extends App {

  val spark = SparkSession.builder().appName("Test Df").master("local").getOrCreate()
  val sc = spark.sparkContext

  val list = List((1, List("a")), (3, List("g")), (1, List("d")))
  val pariRdd:RDD[(Int,List[String])] = sc.parallelize(list)
  //println(pariRdd.collect().toList)

  val grpBy = pariRdd.groupByKey().cache()
  pariRdd.groupByKey()
  grpBy.foreach(println)

  val reduceBy = pariRdd.reduceByKey((x, y) => x++y).distinct()



  reduceBy foreach(println)

  //pariRdd.sortByKey() foreach(println)

}
