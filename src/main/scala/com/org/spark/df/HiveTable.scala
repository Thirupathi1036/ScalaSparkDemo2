package com.org.spark.df

import org.apache.spark.sql.functions._
import org.apache.spark.sql.SparkSession

object HiveTable extends App {

  val spark = SparkSession.builder().appName("Hive Demo").master("local").
    config("spark.sql.warehouse.dir", "/Users/thirupathi.c/IdeaProjects/ScalaSparkDemo/spark-warehouse/")
    .enableHiveSupport().getOrCreate()

  val nameUdf = udf { (name: String) => name.toLowerCase }
  val mulUdf = udf { (a: Int, b: String) => {
    a + "_" + b
  }
  }
  val empHiveFile = "file:///" + getClass.getResource("/").getPath + "employee_hive.txt"
  println("///"+empHiveFile)
  val createDBQuery = "create database if not exists college"
  val createQuery = "create table if not exists college.employee(eid int, name string," +
    "salary string, desgination string) \n" +
    "COMMENT 'Employe Deatils' \n" +
    "ROW FORMAT DELIMITED \n" +
    "FIELDS TERMINATED BY ',' \n" +
    //"LINES TERMINATED BY '\n'' " +
    "STORED AS TEXTFILE"

  //println(createQuery)
  //spark.sql(createDBQuery)
  //spark.sql("show databases").show()
  spark.sql("use college")
  spark.sql("drop table if exists employee")
  spark.sql(createQuery)
  //spark.sql("show tables").show()
  //spark.sql("describe employee").show()
  //spark.sql("LOAD DATA LOCAL INPATH '" + empHiveFile + "' OVERWRITE INTO TABLE employee")

  //spark.sql("select * from employee").show()
  //spark.sql("ALTER TABLE employee1 CHANGE desgination designation STRING")
  //spark.sql("describe employee1").show()
  //spark.sql("select eid,name,salary,desg from(select eid,name,salary,desgination as desg, " +
   // "row_number() over(partition by eid order by salary desc) as row_num from employee) tmp_emp where row_num=1").show()
  //spark.sql("select eid,count(eid) from employee group by eid").show()



}
