package com.org.collection

object ReduceLeftList extends App {

  val list = List(1, 2, 3)
  val list2 = List(4, 5, 6)

  println(list2.fold(0)((a,b)=>a+b))
  val res = List(list, list2).reduceRight((a, b) => a ++ b)
  //val res=List(list,list2).reduceLeft((a,b)=>a++b)
  println(res)
  val res2 = List(list, list2).foldLeft(List.empty[Int])((a, b) => a ++ b)
  println(res2)

  //println(List(list,list2).reduce((a,b)=>a++b).map(_))
}
