package com.org.spark.stack

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object UserTest extends App {


  val fileName = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/stack/user.txt"
  val spark = SparkSession.builder().appName("Test User").master("local").getOrCreate()
  val sc = spark.sparkContext

  import spark.implicits._

  val userDF = spark.read.option("header", true).csv(fileName)
  // userDF.show()
  val groupByUserWinFun = Window.partitionBy("userid","useid1/2")
  val finalScoreDF = userDF.withColumn("useid1/2", when($"userid1".isNull, $"userid2").otherwise($"userid1"))
    .withColumn("finalscore", when($"userid1".isNull, $"score" * 3).otherwise($"score" * 5))
    .withColumn("finalscore", sum("finalscore").over(groupByUserWinFun))
    .select("userid", "useid1/2", "finalscore")
  finalScoreDF.show()

}
