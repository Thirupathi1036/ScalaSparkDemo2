import sys
import numpy as np
import pandas as pd
import mmlspark
import os,urllib

dataFilePath = "AdultCensusIncome.csv"

if not os.path.isfile(dataFilePath):
    urllib.request.urlretrieve("https://mmlspark.azureedge.net/datasets/" + dataFilePath, dataFilePath)
data = spark.createDataFrame(pd.read_csv(dataFilePath, dtype={" hours-per-week": np.float64}))

