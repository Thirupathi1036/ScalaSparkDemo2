from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("Word Count").setMaster("local")
sc = SparkContext(conf=conf)

ll = ["h", "a", "b", "c", "c", "a", "f", "e", "e", "e"]

word_rdd = sc.parallelize(ll)
rrr=word_rdd.map(lambda r: (r, 1)).reduceByKey(lambda a,b:a+b)
print rrr.collect()
