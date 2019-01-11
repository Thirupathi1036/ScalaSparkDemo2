package com.org.spark.util

import org.apache.spark.sql.functions._

object SparkUtils {

  val doubleSalUdf = udf { (sal: Double) => sal * 2 }
  val upperCaseUdf = udf { (name: String) => name.toUpperCase }
  val lowerCaseUdf = udf { (name: String) => name.toLowerCase }
}
