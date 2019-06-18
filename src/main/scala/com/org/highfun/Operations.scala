package com.org.highfun

object Operations extends App {

  def f2[A, B](a: A)(f: A => B): B = f(a)

  def fun(a: Int, b: Int, f: (Int, Int) => Int) = f(a, b)

  def filFun(a: Int, f: (Int) => Boolean): Boolean = f(a)

  println(fun(1, 2, (a, b) => a + b))
  println(fun(1, 2, (a, b) => a - b))
  println(fun(1, 2, (a, b) => a * b))
  println(fun(1, 2, (a, b) => a / b))
  println(f2[Int, String](2)(a => a.toString))
  println(f2[Int, Unit](2)(a => ()))
  println(f2[Int, Int](2)(a => a + 4))
  println(f2[Int, Int](2)(a => a - 1))
  println(f2[Int, Int](2)(a => a * 5))

  println("even: " + filFun(2, a => a % 2 == 0))
  println("odd: " + filFun(2, a => a % 2 == 1))
}
