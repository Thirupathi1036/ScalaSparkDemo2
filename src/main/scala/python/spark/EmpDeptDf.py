from pyspark import SparkContext, SparkConf
from pyspark.sql import SQLContext
from pyspark.sql.types import StringType, Row, StructType, StructField


def start():
    conf = SparkConf().setAppName("Test").setMaster("local")
    sc = SparkContext(conf=conf)
    sql = SQLContext(sc)
    emp_list = [("111", "aaa", "f", "101"), ("222", "bbb", "m", "102"), ("333", "ccc", "f", "101")]
    dept_list = [("101", "IT"), ("102", "DEV"), ("103", "Test")]
    e_schema = StructType([StructField("e_id", StringType(), True),
                           StructField("e_name", StringType(), True),
                           StructField("gender", StringType(), True),
                           StructField("d_id", StringType(), True)])
    d_schema = StructType([StructField("d_id", StringType(), True),
                           StructField("d_name", StringType(), True)])
    e_rdd = sc.parallelize(emp_list)
    e_df = sql.createDataFrame(e_rdd, e_schema)
    d_rdd = sc.parallelize(dept_list)
    d_df = sql.createDataFrame(d_rdd, d_schema)

    join_df=e_df.join(d_df,["d_id"])
    join_df.show()
    final_df=join_df.groupBy("d_id","d_name").count()
    final_df.show()


if __name__ == '__main__':
    start()
