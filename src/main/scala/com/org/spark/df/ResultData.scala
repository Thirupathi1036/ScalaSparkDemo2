package com.org.spark.df

import org.apache.spark.sql.SparkSession

object ResultData  extends App {

  val spark=SparkSession.builder().appName("Spark").master("local").getOrCreate()
  val fileNew="C:\\Users\\thirupathi.c\\Desktop\\data\\part_new.json"
  val fileOld="C:\\Users\\thirupathi.c\\Desktop\\data\\part_old.json"
  val newDf=spark.read.json(fileNew)
  val oldDf=spark.read.json(fileOld)

  newDf.show(5)
  newDf.printSchema()
}
