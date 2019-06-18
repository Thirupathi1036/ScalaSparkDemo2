package com.org.test

import scala.collection.mutable.ListBuffer

object Fibnocci extends App {

  val fibs: Stream[Int] = 0 #:: 1 #:: (fibs zip fibs.tail).map(t => t._1 + t._2)
  println(fibs)
  val res = getFib(6)
  println(res)

  def getFib(n: Int): List[Int] = {
    val listBuffer = ListBuffer.empty[Int]
    val llll = new ListBuffer[Int]
    var a = 0
    var b = 1
    listBuffer.append(a, b)
    var i = 0
    while (i <= n) {
      val c = a + b
      listBuffer.append(c)
      a = b
      b = c
      i = i + 1
    }

    var o = 0
    var p = 1
    listBuffer.append(11111111)
    listBuffer.append(o, p)
    for (i <- 0 to n) {
      val sum = o + p
      listBuffer.append(sum)
      o = p
      p = sum
    }
    listBuffer.toList
  }
}
