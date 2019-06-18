package com.org.spark.df

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object EmpSemicolon {

  def main(args: Array[String]): Unit = {
  }

  val conf = new SparkConf().setAppName("Semi Colon Test").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

  val filePath = getClass().getResource("/emp_semi.csv").getPath
    val df = sqlContext.read.option("delimiter", "$").csv(filePath)
    df.first()
  }