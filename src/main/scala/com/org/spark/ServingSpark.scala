/*
package com.org.spark

import org.apache.spark.sql.DataFrame

import java.util.UUID
import java.util.concurrent.TimeUnit

import com.microsoft.ml.spark.FileUtilities.File
import com.microsoft.ml.spark.ServingImplicits._
import org.apache.http.client.config.RequestConfig
import org.apache.http.impl.client.{CloseableHttpClient, HttpClientBuilder}
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.execution.streaming.continuous._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.{DataStreamWriter, Trigger}
import org.apache.spark.sql.types._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.Try
object ServingSpark {
  def main(args: Array[String]): Unit = {


  }
  def baseDF(numPartitions: Int = 4,
             apiName: String = "Spark Serve",
             apiPath: String = "Test API",
             port: Int = 9090,
             epochLength: Long = 5000): DataFrame = {

    session
      .readStream
      .format(classOf[HTTPSourceProviderV2].getName)
      .address("localhost", port, apiPath)
      .option("name", apiName)
      .option("epochLength", epochLength)
      .option("numPartitions", numPartitions.toLong)
      .load()
  }
}
*/
