package com.org.spark.rdd

import org.apache.spark.HashPartitioner
import org.apache.spark.sql.SparkSession

object HashPartitionDemo extends App {

  val spark = SparkSession.builder().appName("Hash Partitions").master("local[2]").getOrCreate()
  val sc = spark.sparkContext

  val list = List(getTuple(0, 6), getTuple(1, 20), getTuple(3, 16), getTuple(1, 50)).flatten
  list.foreach(println)
  val pairRdd = sc.parallelize(list)
  println(pairRdd.getNumPartitions)

  val hashPart = new HashPartitioner(4)


  val hashPartRdd=pairRdd.partitionBy(hashPart)

  println(hashPartRdd.getNumPartitions)


  def getTuple(i: Int, j: Int) = {
    val res = for (k <- i to j) yield (i, k)
    res
  }
}
