from pyspark import SparkContext, SparkConf
from pyspark.sql import SQLContext
from pyspark.sql import functions as F
from pyspark.sql import Window


def start():
    conf = SparkConf().setAppName("Test").setMaster("local")
    sc = SparkContext(conf=conf)
    sql = SQLContext(sc)
    file_name = ""

    fileName = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/stack/resta.csv"
    df = sql.read.option("header", True).csv(fileName)

    groupByCateWind = Window.partitionBy("Category", "Subcategory")

    finalDf = df.withColumn("names", F.collect_list("Name").over(groupByCateWind)) \
        .withColumn("Subcategories", F.struct("Subcategory", "names")) \
        .groupBy("Category").agg(F.collect_set("Subcategories").alias("Subcategories")).toJSON()

    finalDf.show()
    return None

if __name__ == '__main__':
    start()