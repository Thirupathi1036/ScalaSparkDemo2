package com.org.spark.df

import org.apache.spark.sql.SparkSession

object DeptDF extends App {

  val spark = SparkSession.builder().appName("Dept Df").master("local[2]").getOrCreate()
  val sc = spark.sparkContext

  import spark.implicits._

  val list = List("111,cs", "222,ec", "333,it")
  val empDf = sc.parallelize(list).map { e =>
    val data = e.split(",")
    (data(0), data(1))
  }.toDF("Id", "Name")

  empDf.show()

  empDf.createOrReplaceTempView("dept")
  val df1 = spark.sql("select * from dept")


  val innerJoinDf = empDf.join(empDf, Seq("Id"), "inner")
  //innerJoinDf.show()

  val ourtJoinDf = empDf.join(empDf, Seq("Id"), "outer")
  //ourtJoinDf.show()

  val leftJoinDf = empDf.join(empDf, Seq("Id"), "left_outer")
  // leftJoinDf.show()
  val rightJoinDf = empDf.join(empDf, Seq("Id"), "right_outer")
  //rightJoinDf.show()

  val fullOuterJoinDf = empDf.join(empDf, Seq("Id"), "full_outer")
  //fullOuterJoinDf.show()

  val fullJoinDf = empDf.join(empDf,Seq("Id"),"cross")
  //ullJoinDf.show()
}
