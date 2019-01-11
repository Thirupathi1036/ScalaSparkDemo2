package com.org.func

object RecursionDemo extends App {

  println(factorial(4))

  def factorial(num: Int): Int = {
    if (num <= 1) 1
    else {
      num * factorial(num - 1)
    }
  }
}
