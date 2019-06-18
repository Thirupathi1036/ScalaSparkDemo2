package com.org.test

object DemloNumnbers extends App {

  getNumber(5)

  def fomrNum(times: Int) = {
    val sb = new StringBuilder()
    for (i <- 0 until times) {
      sb.append(1)
    }
    println(sb.toString())
  }

  def getNumber(n: Int) = {
    for (i <- 1 to n) {
      println("Level: " + i + fomrNum(i))
      val num = Seq.fill(i)(1).mkString.toLong
      val res = num * num
      println(res)
    }
  }
}
