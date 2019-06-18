package com.org.collection

object ListDemo2 extends App {

  var list= List.empty[String]
  val list2=list:::List(1,2,3,4)
 // list2.drop(2)
  println(list)
  println(list2.grouped(2))


}
