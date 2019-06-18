package com.org.func

object FunctionDmeo  extends App {

  def getString(num:Int)=num+"**".toString

  val list=List(1,2,3,4,5)
  println(list.map(getString))
}
