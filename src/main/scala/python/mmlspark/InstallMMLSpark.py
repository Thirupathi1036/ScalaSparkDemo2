import pyspark
import sys
import numpy as np
import pandas as pd
import os, urllib

spark = pyspark.sql.SparkSession.builder.appName("MyApp") \
    .config("spark.jars.packages", "Azure:mmlspark:0.17") \
    .getOrCreate()
import mmlspark

dataFilePath = "/Users/thirupathi.c/Downloads/AdultCensusIncome.csv"

if not os.path.isfile(dataFilePath):
    urllib.urlretrieve("https://mmlspark.azureedge.net/datasets/" + dataFilePath, dataFilePath)

data = spark.createDataFrame(pd.read_csv(dataFilePath, dtype={" hours-per-week": np.float64}))

data.show(2)

data = data.select([" education", " marital-status", " hours-per-week", " income"])
train, test = data.randomSplit([0.75, 0.25], seed=123)
train.limit(10).toPandas()


from mmlspark import TrainClassifier
from pyspark.ml.classification import LogisticRegression

model = TrainClassifier(model=LogisticRegression(), labelCol=" income", numFeatures=256).fit(train)

from mmlspark import ComputeModelStatistics, TrainedClassifierModel

prediction = model.transform(test)
prediction.printSchema()

metrics = ComputeModelStatistics().transform(prediction)
metrics.show(10)
metrics.limit(10).toPandas()
