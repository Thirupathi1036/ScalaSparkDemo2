package com.org.test

import scala.io.StdIn

object ArrayLeftRota extends App {

  val ar = Array(1, 2, 3, 4, 5)
  var res = Array.empty[Int]

  val rr = ar.slice(0, 2)
  val tmp = ar.slice(2, ar.length)
  println(rr.toList)
  println(tmp.toList)
  val nn = tmp ++ rr
  println(nn.toList)

  println("enter array and rotation size: ")
  val str = StdIn.readLine()
  val strArray = str.split(" ").map(_.toInt)
  if (strArray.length == 2) {
    val size = strArray(0)
    val rotate = strArray(1)
    val narr = Array.ofDim[Int](size)
    println("enter values: ")
    for (i <- 0 until size) {
      narr(i) = StdIn.readInt()
    }

    println(getRotateArray(narr, rotate).toList)
  }

  def getRotateArray(inArray: Array[Int], rotate: Int) = {
    val slice1 = inArray.slice(0, rotate)
    val slice2 = inArray.slice(rotate, inArray.length)
    slice2 ++ slice1
  }

}
