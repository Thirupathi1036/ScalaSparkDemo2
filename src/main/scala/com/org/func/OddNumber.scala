package com.org.func

object OddNumber extends App {

  val list=List(1,2,3,4,5,6,7,8,9)
  val zip=list.zipWithIndex
  val oddList=list.zipWithIndex.filter(ele=> ele._2%2!=0)
  println(zip)
  println(oddList)
}
