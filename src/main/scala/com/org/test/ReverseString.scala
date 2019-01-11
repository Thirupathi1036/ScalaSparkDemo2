package com.org.test

object ReverseString extends App {

  val str="ABC"
  var res=""
  for(i<- str.length to 1 by -1){
    res=res+str(i-1)
  }
  println(res)
}
