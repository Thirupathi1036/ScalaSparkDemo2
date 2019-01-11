package com.org.collection

object SetDemo extends App {

  var set = Set.empty[Int]
  set += 2
  set+= 1

  println(set)
  println(set.size)

}
