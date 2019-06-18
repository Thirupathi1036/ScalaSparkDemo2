package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

import scala.collection.mutable

object SortByKey extends App {


  val spark = SparkSession.builder().appName("Test Df").master("local").getOrCreate()
  val sc = spark.sparkContext

  def splitt(x: String): (String, String) = {
    val y = x.split(" ")
    (y(0), y(1))
  }

  var tmp_key = ""
  var resMap = Map.empty[String, List[String]]
  var resList = new mutable.MutableList[String]

  def getList(x: String, y: String) = {

    if (resList.isEmpty) {
      resList += y
      tmp_key = x
    } else {
      if (tmp_key == x) {
        resList += y
      }else{
        resMap += tmp_key -> resList.distinct.toList
        resList.clear()
        resList += y
        tmp_key = x
      }
    }
    resMap
  }

  val list = List("a aaa", "b bbb", "c ccc", "a aaaaa", "a aaaaaaa", "b bbbb")

  val pairRdd = sc.parallelize(list).map(splitt).sortByKey()
  val rr = pairRdd.map { tp =>
    getList(tp._1, tp._2)
  }.filter(ele => !ele.isEmpty)
  rr foreach (println)


}

