package com.org.test

import scala.collection.mutable.ListBuffer

object Amex extends App {

  println(get(6000, 7000))

  def get(A: Int, B: Int): Int = {
    val list = new ListBuffer[Double]

    def rec(num: Double): Unit = {
      val res=scala.math.sqrt(num)
      if (res% 2 == 0) {
        list.append(res)
        rec(res)
      }
    }

    val inList = Range(A, B).toList.reverse
    inList.map(x => rec(x))
    println(list)
    list.size
  }
}
