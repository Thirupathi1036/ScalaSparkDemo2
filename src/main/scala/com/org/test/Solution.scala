package com.org.test

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  // Complete the rotLeft function below.
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    val slice1 = a.slice(0, d)
    println(slice1.toList)
    val slice2 = a.slice(d, a.length)
    println(slice2.toList)
    return slice2 ++ slice1

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    //val nd = stdin.readLine.split(" ")

    //val n = nd(0).trim.toInt

    //val d = nd(1).trim.toInt

    //val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val a = Array(1, 2, 3, 4, 5)
    val result = rotLeft(a, 4)
    println(result.mkString(" "))
    // printWriter.println(result.mkString(" "))

    //printWriter.close()
  }
}
