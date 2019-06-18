package com.org.test

import scala.collection.mutable.ListBuffer


object SubStr extends App {

//  val list = List( ".trans[0].id",  ".trans", ".trans[1].id",".cis",".trans[0].id[0].num1", ".trans[0].id[0]",
//    ".trans[0].id[0].num2",".trans[1].id[1].num1")
val list = List( ".trans[0].id",  ".trans", ".trans[1].id",".cis")
  println(list)
  //val res = list.map(x => removeRepeats(list, Some(x)))
  //println(res)
  var set1 = Set.empty[String]

  for (i <- list.indices) {
    val k = list(i)
    for (j <-list.indices) {
      val e = list(j)
      if (!k.equalsIgnoreCase(e) && e.startsWith(k) && !set1.contains(e)) {
        set1 += k
      }
    }
  }
  println(set1)
  val resList=list.diff(set1.toList)
  println(resList.toSet)
}
