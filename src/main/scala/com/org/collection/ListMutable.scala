package com.org.collection

object ListMutable extends App {

  val list=scala.collection.mutable.MutableList.empty[Int]
  list+=2
  list+=1
  println(list.sorted)
}
