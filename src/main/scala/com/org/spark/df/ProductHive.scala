package com.org.spark.df

import org.apache.spark.sql.SparkSession

object ProductHive extends App {

  //
  val spark = SparkSession.builder().appName("Hive Demo").master("local")
    .config("spark.sql.warehouse.dir", "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/spark-warehouse/")
    .config("hive.exec.dynamic.partition.mode", "nonstrict")
    .config("hive.exec.dynamic.partition",true)
    .enableHiveSupport().getOrCreate()

  val fileName = "/Users/thirupathi.c/Downloads/Thirupathi/test_pack/data_for_probs/ecom/ecom_competitor_data.txt"
  val createDBQuery = "create database if not exists college"
  val createQuery = "create table if not exists product(productId long, price float," +
    "saleEvent string, rivalname string,fetchTS string) \n" +
    "COMMENT 'Product Deatils' \n" +
    "ROW FORMAT DELIMITED \n" +
    "FIELDS TERMINATED BY '|' \n" +
    "STORED AS TEXTFILE"

  val createPartTableQuery = "create table if not exists product_part(productId long, price float," +
    "saleEvent string,fetchTS string) \n" +
    "COMMENT 'Product Deatils' \n" +
    "PARTITIONED BY(rivalname string)" +
    "ROW FORMAT DELIMITED \n" +
    "FIELDS TERMINATED BY '|' \n" +
    "STORED AS TEXTFILE"

  //println(createQuery)
  //spark.sql(createDBQuery)
  // spark.sql("show databases").show()
  spark.sql("use college")
  spark.sql("drop table if exists product")
  spark.sql("drop table if exists product_part")
  spark.sql(createQuery)
  spark.sql(createPartTableQuery)
  spark.sql("show tables").show()
  spark.sql("describe product").show()
  spark.sql("describe product_part").show()
  spark.sql("LOAD DATA LOCAL INPATH '" + fileName + "' OVERWRITE INTO TABLE product")
  spark.sql("select * from product").show()
  val insertQuerey="INSERT OVERWRITE table college.product_part PARTITION(rivalname)"+
    " select productId," +
    "price,"+
    "saleEvent," +
    "fetchTS," +
    "cast(replace(rivalname, '.', '_') as string) as rivalname " +
    "from college.product"
  spark.sql(insertQuerey)
  spark.sql("select * from product_part").show()
}
