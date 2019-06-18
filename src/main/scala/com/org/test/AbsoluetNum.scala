package com.org.test

object AbsoluetNum extends App {

  val list = List(1, -2, 3, -4).map(e=> Math.abs(e))
  println(list)
}
