package com.org.test

object ReverseNumber extends App {

  var num = 123
  var sum, rem = 0
  println("Original Num: "+num)
  while (num > 0) {
    rem = num % 10
    sum = (sum * 10) + rem
    num = num / 10
  }

  println("Reverse Num: "+sum)
}
