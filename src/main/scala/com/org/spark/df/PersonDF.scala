package com.org.spark.df

import java.text.SimpleDateFormat

import com.org.model.Person
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object PersonDF extends App {

  val spark = SparkSession.builder().config("spark.ui.showConsoleProgress", true)
    .appName("Pipe Separate").master("local[2]").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  import sqlContext.implicits._

  val path = "C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\src\\main\\resources"
  val personFileName = s"$path\\person.txt"
  val childFile = s"$path\\child.txt"
  val format = new SimpleDateFormat("yyyy-mm-dd")
  /*val personRdd = sc.textFile(personFileName).map { line =>
    val data = line.split("\\|")
    Person(data(0).toInt, data(1), format.parse(data(2)))
  }.toDF()
  personRdd.show()*/


  val personDF = spark.read.option("header", true).option("inferschema", true)
    .option("delimiter", "|").csv(personFileName)
    .withColumn("dob", to_date($"dob"))
    .withColumn("dob_f", date_format($"dob", "dd/MM/yyyy"))
  //personDF.show()

  val childDf = spark.read.option("header", true).option("delimiter", "|").csv(childFile)
  //childDf.printSchema()
  val modifDf = childDf.withColumn("dob", to_date($"dob"))
  //modifDf.printSchema()

  val acols = personDF.columns

  val bcols = childDf.columns
  val intersect = acols.intersect(bcols)
  println("--------- "+ intersect.toSeq)
  val distinctcol = personDF.columns.union(childDf.columns)
    .distinct.map(e => if (intersect.contains(e)) "a." + e else e)
  println("==========Distincyt cols: " + distinctcol.toSeq)
  val joinDf = personDF.alias("a").join(childDf.alias("b"), Seq("p_id")).drop("a.dob")
  joinDf.select("*").show()
  //joinDf.select("p_id","p_name","a.dob","dob_f","c_name")
  joinDf.select(distinctcol.map(e => col(e)): _*)
    .write.mode("overwrite").parquet("C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\parq\\")

}
