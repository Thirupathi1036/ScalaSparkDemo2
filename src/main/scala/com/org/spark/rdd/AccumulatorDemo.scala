package com.org.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object AccumulatorDemo extends App {

  val spark = SparkSession.builder().appName("Accumulator").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  //var numAcc = sc.accumulator(0)
  var numAcc = sc.longAccumulator("Name")

  val list = List("hai", "wel", "come", "hai", "spark", "hadoop", "spark", "hai", "hive")
  val wordsRdd = sc.parallelize(list)
  val strRdd = sc.parallelize(list).map { ele =>
    if (ele.equalsIgnoreCase("hai")) numAcc.add(2)
  }
  val firstRec = wordsRdd.first()
  println(wordsRdd.filter(ele => !ele.equalsIgnoreCase(firstRec)).collect().toList)

  println(numAcc.value)
  println(wordsRdd.take(2).toList)
  println("======================  wordsRdd: " + checkRddEmpty(wordsRdd))

  val emptyRdd = sc.emptyRDD[String]
  println("======================  emptyRdd: " + checkRddEmpty(emptyRdd))

  def checkRddEmpty(rdd: RDD[String]) = rdd.isEmpty()

  val red = wordsRdd.map(e => (e, 1)).reduceByKey((e, v) => e + v)
  red foreach (println)

  val numbers = sc.parallelize((1 to 100).toList)
  val splits = numbers.randomSplit(Array(0.001))
  splits.foreach(e => println(e.collect().toList))
  val sample = numbers.sample(false, 0.1)
  println("===============================\n"+sample.count())
}
