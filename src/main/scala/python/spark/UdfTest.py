from pyspark import SparkContext, SparkConf
from pyspark.sql import SQLContext
from pyspark.sql import functions as F
from pyspark.sql.types import StringType,Row


# registered to get Item in SparkSQL.
def getItem(it):
    return 'Non-Fat Dry Milk' if it == '23040010' else 'foo'


columntransform = F.udf(getItem, StringType())


def start():
    conf = SparkConf().setAppName("Test").setMaster("local")
    sc = SparkContext(conf=conf)
    sql = SQLContext(sc)
    ll = ["23040010", "23040011", "23040012", "23040013", "23040010"]
    n_rdd = sc.parallelize(ll).map(lambda row: Row(row))
    df = sql.createDataFrame(n_rdd, ["nums"])
    df.withColumn("NewItem",columntransform(df["nums"])).show()
    return None


if __name__ == '__main__':
    start()
