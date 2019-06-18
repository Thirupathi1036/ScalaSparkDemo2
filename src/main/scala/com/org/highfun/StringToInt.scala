package com.org.highfun

object StringToInt extends App {

  def isEven(n: Int) = n % 2 == 0

  def isOdd(n: Int) = n % 2 == 1

  val even = (n: Int) => Boolean

  def filter(x: Int, f: Int => Boolean) = f(x)

  val list = List(1, 2, 3, 4, 5, 6, 7).filter(x => filter(x, x=> (x % 2 == 0)))
  println(list)
  println(even)

}
