package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object RddPart4 extends App {

  val spark = SparkSession.builder().appName("Test4").master("local[2]").getOrCreate()
  val sc = spark.sparkContext

  val list1 = Range(1, 10).toList ++ Range(1, 5).toList
  val list2 = Range(1, 20).toList ++ Range(1, 15).toList

  println(list1)
  println(list2)

  val rdd1 = sc.parallelize(list1, 5).filter(_ % 2 == 0).distinct()

  println(rdd1.collect().toList)

  val rdd2 = sc.parallelize(list2, 10).filter(_ % 2 == 1).distinct()

  println(rdd2.collect().toList)
  val unionRdd = rdd1.union(rdd2)
  println(unionRdd.collect().toList)

  val reduceRdd=List(rdd1,rdd2).reduce(_.union(_))

  println(reduceRdd.collect().toList)


  println(rdd1.getNumPartitions)
  println(rdd2.getNumPartitions)
  println(unionRdd.getNumPartitions)
  println(reduceRdd.getNumPartitions)


}
