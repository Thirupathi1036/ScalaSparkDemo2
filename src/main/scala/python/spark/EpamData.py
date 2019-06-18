from pyspark import SparkContext, SparkConf
import json


def create_data(line):
    return line[id], line['text']


def get_count(list_data):
    return map(lambda x: (x, 1), filter(lambda y: y != '' and y is not None, list_data))


def start():
    conf = SparkConf().setAppName("Word Count").setMaster("local")
    sc = SparkContext(conf=conf)
    file_name = "/Users/thirupathi.c/Downloads/Thiru/ScalaSparkDemo/src/main/resources/epam.json"
    rdd = sc.textFile(file_name).map(lambda line: json.loads(line))
    text_rdd = rdd.map(lambda x: (x["id"], x["text"].split("#")))
    print text_rdd.collect()

    count_rdd = text_rdd.map(lambda (x, y): get_count(y)).flatMap(lambda y: y).reduceByKey(lambda a, b: a + b)
    print count_rdd.collect()


if __name__ == '__main__':
    start()
