package com.org.highfun

object ArithOperation extends App {

  def operation[A, B](a: A, b: A, f: (A, A) => B) = f(a, b)

  val add = operation[Int, Double](10, 20, (a, b) => a + b)
  val mul = operation[Int, Double](10, 20, (a, b) => a * b)
  val printData = operation[String, Unit]("A", "Welcome", (a, b) => println(a, b))
  println(add)


}
