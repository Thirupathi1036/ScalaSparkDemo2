package com.org.spark.rdd

import org.apache.spark.sql.SparkSession

object AccDemo extends App {

  val spark=SparkSession.builder().appName("Acc").master("local[2]").getOrCreate()

  val list=List(1,2,3,4,5,6,7,8,9,10)
  val sc=spark.sparkContext
  var aa=0
  val acc=sc.longAccumulator
  val numRdd=sc.parallelize(list).map{n=>
    if(n%2==0) {
      aa = aa + 1
      acc.add(1)
    }
  }
  numRdd.count()
  println(aa)
  println(acc)
}
