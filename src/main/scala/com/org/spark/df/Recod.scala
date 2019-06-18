package com.org.spark.df

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.ArrayType

import scala.collection.mutable

case class Data(listData: Seq[(String, Int)])

object Recod extends App {

  val sortUdf = udf { (listCols: mutable.WrappedArray[(String, Int)]) =>

    println(listCols.toSeq)
    "hello"
  }

  val spark = SparkSession.builder().appName("Tesr").master("local").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val sqlContext = spark.sqlContext
  val georecommendation_path = "C:/Thiru/Project/Move/nearby_input/recommended_cities.csv"
  val w = Window.partitionBy("search_geo_name").orderBy("reco_geo_rank")

  val recommended_cities = sqlContext.read.format("com.databricks.spark.csv")
    .option("header", true)
    .option("inferschema", true)
    .option("mode", "PERMISSIVE")
    .load(georecommendation_path)
    .groupBy("search_geo_name")
    .agg(collect_list(struct("reco_geo_name", "reco_geo_rank")).alias("reco_geo_name"))
    .rdd.map { r => (r.getString(0), r.getAs[Seq[Row]](1).map(rr => (rr.getString(0), rr.getInt(1))).sortBy(_._2).map(_._1)) }
    .groupByKey().mapValues(_.flatten)
  recommended_cities.collect() foreach (println)
  //recommended_cities.show(false)
  //recommended_cities.printSchema()

}
