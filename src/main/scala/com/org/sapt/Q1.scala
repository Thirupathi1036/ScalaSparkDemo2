package com.org.sapt

import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object Q1 extends App {

  val spark = SparkSession.builder().appName("Q1 Test").master("local[2]").getOrCreate()
  val sc = spark.sparkContext

  import spark.implicits._

  val fileEcomComp = "/Users/thirupathi.c/Downloads/Thirupathi/test_pack/data_for_probs/ecom/ecom_competitor_data.txt"
  val fileInternalData = "/Users/thirupathi.c/Downloads/Thirupathi/test_pack/data_for_probs/ecom/internal_product_data.txt"
  val fileSellar = "/Users/thirupathi.c/Downloads/Thirupathi/test_pack/data_for_probs/ecom/seller_data.txt"

  val compitDF = createDF(fileEcomComp, "|")

  val interalDF = createDF(fileInternalData, "|")

  val sellarDF = createDF(fileSellar, "|")

  val finalPriceUDf = udf { (pc: Double, q: Double, maxMar: Double, minMar: Double, saleEvent: String, clasfic: String) => {
    if (q < pc && saleEvent.toLowerCase.equals("Special") && clasfic.toLowerCase.equals("VeryHigh")) q
    else if (pc < q && saleEvent.toLowerCase.equals("Special")) 0.9 * pc
    else if (pc + maxMar <= q) pc + maxMar
    else if (pc + minMar <= q) q
    else pc
  }
  }
  val cheapPriceUdf = udf { (list: Seq[Double]) => list.min }

  val compiterInternalDataDF = compitDF.join(interalDF, Seq("ProductId"))
  val allDataDF = compiterInternalDataDF.join(sellarDF, Seq("SellerID"))

  val selectColmns = Seq("productId", "finalprice", "fetchTS", "cheapPriceRival", "rivalName").map(col(_))

  //val groupByRival = Window.partitionBy("productId").orderBy("price")
  val groupByProduct = Window.partitionBy("productId").orderBy("price")


  val grpProductDf = allDataDF.withColumn("priceList", collect_set("price").over(groupByProduct))
    .withColumn("cheapPrice", cheapPriceUdf($"priceList"))
    .withColumn("finalprice", finalPriceUDf($"procuredValue", $"cheapPrice", $"maxMargin", $"minMargin", $"saleEvent", $"netValue"))
    .withColumn("dr", dense_rank().over(groupByProduct))
    .withColumnRenamed("price", "cheapPriceRival")
    // .withColumn("TimeStamp",current_timestamp())
    .filter($"dr" === 1)

  grpProductDf.select(selectColmns: _*).show(false)

  def createDF(fileName: String, delim: String): DataFrame = spark.read.option("header", true).option("inferSchema", true)
    .option("delimiter", delim).csv(fileName)

  //set hive.exec.dynamic.partition=true;
  //set hive.exec.dynamic.partition.mode=nonstrict;

  /** insert overwrite table db.table1 partition(rivalName)
    * select productId,price,saleEvent,fetchTS,regexp_replace(rivalName,'\.','_') as rivalName
    * from db.table2 */
}
