package com.org.test

object StringRotation extends App {

  val str = "ABCD"
  val str2 = "CDAB"

  if (str.length == str2.length && str.concat(str).contains(str2)) {
    println("rotation")
  } else {
    println("not rotation")
  }
}
