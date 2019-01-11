package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

import scala.collection.mutable

object GroupByKeyDemo extends App {

  val spark = SparkSession.builder().appName("GroupBy Key").master("local").getOrCreate()
  val sc = spark.sparkContext

  val keysWithValuesList = Array("foo=A", "foo=A", "foo=A", "foo=A", "foo=B", "bar=C", "bar=D", "bar=D")
  val data = sc.parallelize(keysWithValuesList)
  //Create key value pairs
  val kv = data.map(_.split("=")).map(v => (v(0), v(1))).cache()

  val initialSet = mutable.HashSet.empty[String]
  val addToSet = (s: mutable.HashSet[String], v: String) => s += v
  val mergePartitionSets = (p1: mutable.HashSet[String], p2: mutable.HashSet[String]) => p1 ++= p2

  val uniqueByKey = kv.aggregateByKey(initialSet)(addToSet, mergePartitionSets)

  println(uniqueByKey.collect().toList)
}
