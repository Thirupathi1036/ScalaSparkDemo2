package com.org.spark.df

import com.org.model.{Dept, Employee}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import com.org.spark.util.SparkUtils._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import com.org.file._

object EmpDeptDF extends App {

  val empFile = "C:\\Thiru\\Jars\\input\\emp.txt"
  val deptFile = "C:\\Thiru\\Jars\\input\\dept.txt"
  //val empFile = FileUtils.getResourcePath("/emp.txt")
  //val deptFile = FileUtils.getResourcePath("/dept.txt")

  val spark = SparkSession.builder().appName("Emp Dept App").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  import sqlContext.implicits._

  val empRdd: RDD[Employee] = sc.textFile(empFile).map { line =>
    val data = line.split(",")
    Employee(data(0).toLong, data(1), data(2), data(3), data(4).toDouble, data(5).toLong)
  }

  val empDS = empRdd.toDF()

  val deptRdd = sc.textFile(deptFile).map { line =>
    val data = line.split(",")
    Dept(data(0).toLong, data(1))
  }
  val deptDS = deptRdd.toDS()

  //val upperNameDF: DataFrame = empDS.withColumn("empName", upperCaseUdf($"empName"))
  //upperNameDF.show()
  val doubleSalDF = empDS.withColumn("empName", upperCaseUdf($"empName"))
    .withColumn("salary", doubleSalUdf($"salary"))

  val empDeptDf = empDS.join(deptDS, Seq("deptId"), "left").filter($""=!="")

  //empDeptDf.show()
  val secondMaxSal = Window.partitionBy($"deptName").orderBy($"salary".desc)
  /*val maxSalByDept = empDeptDf.select("deptName","salary").
    withColumn("row_num",row_number.over(secondMaxSal)).filter($"row_num"===2)
    .drop("row_num").orderBy($"salary".desc)*/
  val maxSalByDept = empDeptDf.
    withColumn("row_num", row_number().over(secondMaxSal))
    .withColumn("dense_rank",dense_rank().over(secondMaxSal))
    .withColumn("rank",rank().over(secondMaxSal)).distinct()
    //.filter($"row_num" === 2).drop("row_num")
  maxSalByDept.show()
  //maxSalByDept.head()
}
