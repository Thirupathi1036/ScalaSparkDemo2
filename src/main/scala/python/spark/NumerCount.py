import json
from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("Count")
sc = SparkContext(conf=conf)
a1=[1,2,3,4,3,4,5,6,3,4,5,6]
