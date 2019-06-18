package com.org.spark.df

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SQLContext, SparkSession}

object Tc4a extends App {

  //val sc=SparkContext()
  //val sqlContext=SQLContext(sc)
  val spark = SparkSession.builder().appName("TC 4a").master("local[2]").getOrCreate()
  val patientProfileDataFile = "C:\\Thiru\\Project\\new_Project\\PatientProfileData.json"
  val patientDataFile = "C:\\Thiru\\Project\\new_Project\\PatientData.csv"
  //s3://patient_data/PatientData.csv
  //s3://patient_profile/PatientProfileData.json

  val pdDf = spark.read.option("header", true).option("inferschema", true).csv(patientDataFile)
  val patientDataDF = renameColums(pdDf)
  val patientProfileDataDF = spark.read.option("multiline", true).json(patientProfileDataFile)
  val ppdDF = patientProfileDataDF.columns.foldLeft(patientProfileDataDF) { (new_df, colName) =>
    new_df.withColumnRenamed(colName, colName.replaceAll("[\\s:\\-(/]+", "_").
      replace(")", ""))
  }

  val combineDataDF = ppdDF.join(patientDataDF, "Case_ID")
  //combineDataDF.show()

  println("=========" + combineDataDF.count())

  combineDataDF.write.option("header", true).mode("overwrite").csv("s3://patient_profile/final_csv")

  def renameColums(df: DataFrame): DataFrame = {
    df.columns.foldLeft(df) { (new_df, colName) =>
      new_df.withColumnRenamed(colName, colName.trim.replaceAll("[\\s:\\-(/#]+", "_").
        replace(")", ""))
    }
  }
}
