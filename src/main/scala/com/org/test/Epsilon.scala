package com.org.test

object Epsilon extends App {

  val in1 = 2
  val in2 = Array("abcd", "cdab")

  getPass(in1, in2)

  def getPass(in1: Int, in2: Array[String]) = {
    val sortedList = in2.map(_.toLowerCase).map(x => new String(x.toCharArray.sortBy(c => c))).toList

    println(sortedList)
  }


}
