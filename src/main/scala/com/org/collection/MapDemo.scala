package com.org.collection

object MapDemo extends App {

  val map1 = Map(2 -> 22, 3 -> 33)
  var map = Map.empty[Int, Int]
  map += 1 -> 11
  val map3=map1++map

  println(map)
  println(map3)
  val map4=map3.updated(1,44)
  println(map4.slice(0,1))
}
