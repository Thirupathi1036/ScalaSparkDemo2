
from pyspark.sql.functions import udf, col, length
from pyspark.sql.types import *

import pyspark
spark = pyspark.sql.SparkSession.builder.appName("MyApp") \
    .config("spark.jars.packages", "Azure:mmlspark:0.17") \
    .getOrCreate()
import mmlspark


df = spark.readStream.server() \
    .address("localhost", 8888, "my_api") \
    .load() \
    .parseRequest(StructType().add("foo", StringType()).add("bar", IntegerType()))

replies = df.withColumn("fooLength", length(col("foo"))) \
    .makeReply("fooLength")

server = replies \
    .writeStream \
    .server() \
    .replyTo("my_api") \
    .queryName("my_query") \
    .option("checkpointLocation", "file:////Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/serving/") \
    .start()

