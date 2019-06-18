package com.org.spark.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object RddDemo extends App {

  val spark = SparkSession.builder().master("local").appName("Demo Rdd").getOrCreate()
  val list = "hello how are you hello are you ok when spark hello".split(" ")
  val sc = spark.sparkContext
  val strRdd: RDD[(String, scala.Iterable[String])] = sc.parallelize(list).groupBy(w => w)
  //getFiltered(strRdd, "you")
  strRdd.map{data=> if(data._2.size <2) data._2.+("===") else data._2}

  //println(strRdd.top(2).collect().toList)

  /*def getFiltered(rdd: RDD[(String, scala.Iterable[String])], key: String) = {
    var list = scala.collection.mutable.MutableList.empty[String]
    rdd.map { e =>
      if (e._1 == key) list ++ e._2.toList
      else List.empty
    }
    println(list)
  }*/


}
