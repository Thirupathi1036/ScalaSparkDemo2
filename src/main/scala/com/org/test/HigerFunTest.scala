package com.org.test

object HigerFunTest extends App {

  def operation[A](a: A, b: A, f: (A, A) => A): A = f(a, b)

  def printHigh[A, B](a: A, f: (A) => B): B = f(a)

  def checkBool[A, Boolean](a: A, f: (A) => Boolean): Boolean = f(a)

  println(operation[Int](1, 2, (a, b) => a + b))
  println(operation[Float](1, 2, (a, b) => a - b))

  printHigh[String, Unit]("helloo", println)

  println(checkBool[Int,Boolean](2,a=>a%2==0))
  println(checkBool[Int,Boolean](2,a=>a%2==1))

}
