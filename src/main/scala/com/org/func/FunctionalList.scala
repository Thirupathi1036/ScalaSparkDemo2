package com.org.func

object FunctionalList extends App {

  val mul_func = (num: Int) => num * 10

  val list = List(1, 2, 3, 4, 5).map(multi)
  println(list)
  def multi(num:Int)=num*10

}
