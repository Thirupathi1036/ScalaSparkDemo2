package com.org.basic

object OptionDemo extends App {

  val list = List(Some(9), None, Some(4), Some(3), None)

  val data = list.filter(_.isDefined).map(_.get)

  println(data.reduce((a, b) => a + b))
  println(data.fold(0)((a, b) => a + b))
  println(list)
  println(list.map(_.getOrElse(1)))
  println(list.filter(_.isDefined).map(_.get))
  println(list.filter(!_.isDefined))
}
