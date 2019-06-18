package com.org.spark.df

import org.apache.spark.sql.SparkSession

object EmpHiveTable {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("EMp Hive").master("local[2]")
      .config("set.hive.enforce.bucketing","true")
      .config("hive.exec.dynamic.partition.mode", "nonstrict")
      .config("spark.sql.warehouse.dir", "file:///C:/Users/thirupathi.c/IdeaProjects/ScalaSparkDemo/spark-warehouse/")
      .enableHiveSupport().getOrCreate()
    val sc = spark.sparkContext
    val sqlContext = spark.sqlContext
    val fileName = "file:///" + getClass().getResource("/emp.txt").getPath

    val createTableQuery = "CREATE TABLE IF NOT EXISTS emp_non_part(emp_id integer," +
      "emp_name string,gender string,loc string,salary double,dept_id integer)" +
      "\n COMMENT 'Employee Non Partition Table'" +
      "\n ROW FORMAT DELIMITED" +
      "\n FIELDS TERMINATED BY ','" +
      "\n STORED AS TEXTFILE"


    //sqlContext.sql("CREATE DATABASE IF NOT EXISTS emp")
    sqlContext.sql("USE emp")
    //sqlContext.sql("DROP TABLE emp_non_part")
    //sqlContext.sql(createTableQuery)
    //sqlContext.sql("SHOW TABLES").show()
    //sqlContext.sql("DESC EMP_NON_PART") show()
    //sqlContext.sql("LOAD DATA LOCAL INPATH '" + fileName + "' INTO TABLE emp_non_part")
    //sqlContext.sql("SELECT * FROM EMP_NON_PART").show()

    //************  Partition Table Queries Starts here   *****************************

    val hiveTblPartQuery = "CREATE TABLE IF NOT EXISTS emp_part(emp_id integer,emp_name string," +
      "gender string,salary decimal,dept_id integer)" +
      "\nPARTITIONED BY (loc string)" +
      "\nCOMMENT 'Employee Partition Table'" +
      "\n ROW FORMAT DELIMITED" +
      "\nFIELDS TERMINATED BY ','" +
      "\nSTORED AS TEXTFILE"

    val insertQuery = "INSERT OVERWRITE TABLE emp_part PARTITION(loc) " +
      "SELECT emp_id,emp_name,gender,salary,dept_id,loc FROM emp_non_part"
    // sqlContext.sql("DROP TABLE IF EXISTS emp_part")
    //sqlContext.sql(hiveTblPartQuery)
    //sqlContext.sql("SHOW TABLES").show()
    //sqlContext.sql(insertQuery)
    //sqlContext.sql("SELECT * FROM emp_part").show()
    //sqlContext.sql("SELECT count(*) as total_count FROM emp_part").show()

    /* ***************  Hive Bucketing Example start from here ************  */

    val hiveBucketQuery = "CREATE TABLE IF NOT EXISTS emp_buck(emp_id integer,emp_name string," +
      "gender string,salary float,dept_id integer)" +
      "\n CLUSTERED BY (emp_id) INTO 3 BUCKETS" +
      "\n COMMENT 'Employee Bucket Table'" +
      "\n ROW FORMAT DELIMITED " +
      "\n FIELDS TERMINATED BY ','" +
      "\n STORED AS TEXTFILE"
    val hiveBuckInsertQuery = "INSERT OVERWRITE TABLE emp_buck SELECT emp_id,emp_name,gender," +
      "salary,dept_id FROM emp_non_part"
    sqlContext.sql("DROP TABLE IF EXISTS emp_buck")
    sqlContext.sql(hiveBucketQuery)
    sqlContext.sql("SHOW TABLES").show()
    sqlContext.sql(hiveBuckInsertQuery)
    sqlContext.sql("SELECT * FROM emp_buck").show()


  }
}
