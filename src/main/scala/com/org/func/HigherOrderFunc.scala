package com.org.func

object HigherOrderFunc extends App {

  val f = (a: Int) => (a.toInt * a.toInt)

  val upper=(s:String)=> s.toUpperCase
  val list = List(1, 2).map(f(_))
  println(list)

  val words=List("hi","hello").map(upper)
  println(words)
}
