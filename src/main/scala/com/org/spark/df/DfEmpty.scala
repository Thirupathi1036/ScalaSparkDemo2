package com.org.spark.df

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object DfEmpty extends App {


  def upperCase(name: String) = name.toUpperCase

  //val upperCase = udf(upperCase)

  val spark = SparkSession.builder().appName("Empty Check").master("local").getOrCreate()
  val sc = spark.sparkContext
  val sqlContewxt = spark.sqlContext

  import sqlContewxt.implicits._

  val list = List(("scala",1), ("java",2), ("spark",3))

  val wordsRdd = sc.parallelize(list).toDF("Names","Num")
  wordsRdd.show()

  println("======= head ==========   " + wordsRdd.head(1).isEmpty)
  println("== rdd ==  " + wordsRdd.rdd.isEmpty())

  val emptyList = List("").toSeq
  val emptyDf = sc.parallelize(emptyList).toDF("words")
  emptyDf.show()

  println("empty List DF +++++++++++++++ " + emptyDf.head(1).isEmpty)
  val emptyDF = sqlContewxt.emptyDataFrame

  println("------------- empty " + emptyDF.head(1).isEmpty)


  wordsRdd.rollup("Num").avg().show()
}
