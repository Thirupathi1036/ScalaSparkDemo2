package com.org.spark.util

import org.apache.spark.sql.SparkSession

object SessionSpark {
  def getSparkSession(appName: String = "testing", master: String = "local"): SparkSession = {
    val spark = SparkSession.builder().appName(appName).master(master).getOrCreate()
    spark
  }
}
