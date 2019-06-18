package com.org.test

object SwapNum extends App {

  var a=12
  var b=22

  b=a+b
  a=b-a
  b=b-a

  println(a)
  println(b)

}
