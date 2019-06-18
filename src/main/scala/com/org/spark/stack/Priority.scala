package com.org.spark.stack

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object Priority extends App {

  val spark=SparkSession.builder().appName("Test").master("local[2]").getOrCreate()
  import spark.implicits._
  val targetDF = Seq(
    ("110", "EMAIL2@TEST.COM", "", "2"),
    ("110", "EMAIL2@TEST.COM", "PAH", "2"),
    ("114", "EMAIL10@TEST.COM", "AAH", "2"),
    ("114", "EMAIL10@TEST.COM", "", "2")
  )
    .toDF(
      "role_num",
      "email_address",
      "role",
      "counters")

  val res=targetDF
    .withColumn("priority", rank().over(Window.partitionBy("role_num").orderBy(desc_nulls_last("role"))))
    .where(col("priority") === 1)
    .drop("priority")


  res.show()
}
