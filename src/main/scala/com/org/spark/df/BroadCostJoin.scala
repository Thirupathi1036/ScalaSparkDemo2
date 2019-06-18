package com.org.spark.df

import com.org.model.{Dept, Employee}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object BroadCostJoin extends App {

  val spark = SparkSession.builder().appName("BroadCost").master("local").getOrCreate()
  val sc = spark.sparkContext

  import spark.implicits._

  val sqlContext = spark.sqlContext
  val path = getClass.getResource("/")
  val empPath = path + "emp.txt"
  val deptPath = path + "dept.txt"
  println("==================path: " + empPath)
  val empDF = sc.textFile(empPath).map { line =>
    val data = line.split(",")
    Employee(data(0).toLong, data(1), data(2), data(3), data(4).toDouble, data(5).toLong)
  }.toDF()

  empDF.show(3)

  val deptDF = sc.textFile(deptPath).map { line =>
    val data = line.split(",")
    Dept(data(0).toLong, data(1))
  }.toDF()

  val deptBroadCost = sc.broadcast(deptDF)
  val bcols = deptBroadCost.value.columns.map { e => "b." + e }
  val acol = empDF.columns.map { c => "a." + c }
  val joinDF = empDF.alias("a").join(deptBroadCost.value.alias("b"), Seq("deptId"))
  joinDF.select("*").show(5)
  val allcol = acol.union(bcols).toSeq
  val colDf=joinDF.select(allcol.map { c => col(c) }: _*)
  colDf.show(3)
}
