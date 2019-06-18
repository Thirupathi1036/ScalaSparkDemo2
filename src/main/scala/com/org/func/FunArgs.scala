package com.org.func

object FunArgs {

  def get(a: Int, b: Int) = a + b

  def getInt(a: Int) = a + 10

  val testFun = (a: Int, b: Int) => a + b
  //val testFun2 = (a:Int => String) = a.toString
  val test2: Int => String = a => a.toString

  def op(a: Int, b: Int, f: (Int, Int) => Int) = f(a, b)

  def opAny[A, B](a: A, b: B, f: (A, B) => B) = f(a, b)

  def main(args: Array[String]): Unit = {

    val res = get(3, getInt(3))
    println(res)

    println(op(1, 2, (a, b) => a + b))
    println(op(1, 3, (a, b) => a - b))
    println(opAny[Int, Double](1, 3, (a, b) => a + b))
  }
}
