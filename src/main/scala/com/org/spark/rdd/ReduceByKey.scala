package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object ReduceByKey extends App {

  val spark = SparkSession.builder().appName("REduceBy Key").master("local").getOrCreate()
  val str = "1 hyd;2 blr;3 chn;1 del;4 mum;1 koch;2 wgl;1 bza;2 sec".split(";")
  val wordRdd = spark.sparkContext.parallelize(str).map { word =>
    val data = word.split(" ")
    (data(0), Seq(data(1)))
  }
  wordRdd.groupByKey().mapValues(e=>e.flatMap(e=>e)).foreach(println)
  println("=============================================")
  wordRdd.reduceByKey((a, b) => a ++ b).sortBy(x=>x._1).repartition(1).foreach(println)
  //wordRdd.keyBy(e=> e._1).foreach(println)
  wordRdd.count()
}
