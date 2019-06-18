package com.org.test

import org.apache.spark.sql.hive.HiveContext

object MakeAngram extends App {

  val str1 = "abc"
  val str2 = "cde"

  val sArray1 = sortString(str1)
  val sArray2 = sortString(str2)
  println(sArray1.intersect(sArray2))



  def doSort(str: String) = str.sortBy(c => c)

  def sortString(str: String): String = {
    val strArray = str.toCharArray
    for (i <- 0 until strArray.length) {
      for (j <- i until strArray.length) {
        if (strArray(i) > strArray(j)) {
          val tmp = strArray(i)
          strArray(i) = strArray(j)
          strArray(j) = tmp
        }
      }
    }
    return new String(strArray)
  }
}