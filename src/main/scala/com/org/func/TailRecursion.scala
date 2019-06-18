package com.org.func

object TailRecursion extends App {


  println("Tail Recursion: "+factorial(1))
  def factorial(num: Int):Int = {

    def fact(n: Int, res: Int): Int = {
      if (n < 1) res
      else {
        fact(n - 1, n * res)
      }
    }

    fact(num, 1)
  }
}
