package com.org.spark.rdd

import com.org.model.Person
import org.apache.spark.sql.SparkSession

object PersonGroupByKey extends App {

  val spark = SparkSession.builder().appName("Group Demo").master("local").getOrCreate()
  val sc = spark.sparkContext
  val sqlContext = spark.sqlContext

  import spark.implicits._

  val p1 = Person(111, "aaa", "21-09-2018")
  val p2 = Person(222, "bbb", "23-09-2018")
  val p3 = Person(111, "ccc", "12-09-2018")

  val personRdd = sc.parallelize(Seq(p1, p2, p3))
  val idRdd = personRdd.groupBy(p => p.p_id)
  idRdd foreach (println)
  idRdd.toDF("id", "Person").show()

}
