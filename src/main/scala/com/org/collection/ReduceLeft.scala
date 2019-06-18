package com.org.collection

object ReduceLeft extends App {

  val list = List(1, 2, 3, 4)
  println(list.foldLeft(0)((a, b) => a + b))
  println(list.foldRight(0)((a, b) => a + b))

  println(list.foldLeft(0)((a, b) => a - b))
  println(list.foldRight(0)((a, b) => a - b))

  println(list.reduceLeft((a, b) => a + b))
  println(list.reduceRight((a, b) => a + b))

  println(list.reduceLeft((a, b) => a - b))
  println(list.reduceRight((a, b) => a - b))

}
