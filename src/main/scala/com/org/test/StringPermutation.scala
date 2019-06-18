package com.org.test

object StringPermutation extends App {

  val str = "ABC"
  val set = scala.collection.mutable.Set.empty[String]

  permutation("", str)


  def permutation(prefix: String, str: String): Unit = {
    val len = str.length
    if (len == 0) {
      println(prefix)
      set.add(prefix)
    } else {
      for (i <- 0 until len) {
       // val j = i + 1
       // println(prefix + str.charAt(i) + "\t" + i + "<-" + str.substring(0, i) + "." + str.substring(j, len))
        permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1))
      }
    }
  }
  /*
  * A	0<-.BC
AB	0<-.C
ABC	0<-.
ABC
AC	1<-B.
ACB	0<-.
ACB
*/
  println(set)
}
