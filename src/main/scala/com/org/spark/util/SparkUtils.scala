package com.org.spark.util

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions._

object SparkUtils {

  def checkRddEmpty(rdd: RDD[String]) = rdd.isEmpty()

  val doubleSalUdf = udf { (sal: Double) => sal * 2 }
  val upperCaseUdf = udf { (name: String) => name.toUpperCase }
  val lowerCaseUdf = udf { (name: String) => name.toLowerCase }
}
