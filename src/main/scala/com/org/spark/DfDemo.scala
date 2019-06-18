package com.org.spark

import org.apache.spark.rdd.RDD

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

case class Emp(dept_id: Int, name: String)

case class Dept(dept_id: Int, dept_name: String, reco_id: Int)

object DfDemo extends App {

  val spark = SparkSession.builder().appName("Test Df").master("local").getOrCreate()
  val sc = spark.sparkContext
  val list = List((1, "aaa"), (2, "bbb"), (1, "ddd"), (3, "ccc"))
  val list2 = List((1, "CSE", 2), (2, "EE", 1), (3, "EC", 4))

  import spark.sqlContext.implicits._

  val rdd2:RDD[(Int,String)]=sc.parallelize(list)
  var empDf:DataFrame = sc.parallelize(list).map { line => Emp(line._1, line._2) }.toDF().cache()
  val deptDf = sc.parallelize(list2).map { line => Dept(line._1, line._2, line._3) }.toDF()
  val sel_col = empDf.columns
  val temp_df = empDf.filter($"dept_id" === 1).toJSON.collectAsList().mkString
  //empDf = empDf.join(deptDf, Seq("dept_id")).withColumn("reco", when(empDf("dept_id") === deptDf("reco_id"), temp_df).otherwise(""))
  var joinDf = empDf.filter($"dept_id" === 2).join(deptDf, Seq("dept_id"))
  joinDf.show()

  joinDf = joinDf.withColumn("New_Col", lit(empDf.filter($"dept_id" === joinDf("dept_id")).toJSON.collectAsList().mkString))
  val nw_df = joinDf.drop("reco_id", "dept_name")

  nw_df.union(empDf.withColumn("ne_col", lit(""))).show(false)
  //joinDf.select(sel_col.map(col(_)): _*).show()
joinDf.write.json("")
  val listDf = List(empDf, deptDf)

  joinDf.groupBy()

}
