package com.org.test

object FindMissNum extends App {

  val numList=Array(1,2,3,5).toList.sum
  val numList2=Range(1,5+1).toList.sum
  //println(numList2.diff(numList))
  println(numList)
  println(numList2)
  println(numList2-numList)
}
