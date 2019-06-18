package com.org.spark

object NumberCount {

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 3, 3, 3, 4, 5, 5, 6, 7, 8, 1, 1, 2, 3, 4, 5, 6, 7, 7,3)
    val res=list.groupBy(n=>n).mapValues(_.size).toSeq.sortBy(_._2).reverse
    println(res)

  }
}
