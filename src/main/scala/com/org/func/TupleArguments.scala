package com.org.func

object TupleArguments extends App {

  def convertTuple(t3: (Int, String)): Tuple2[String, String] = {
    (t3._1.toString, t3._2)

  }

  val tpl = (1, "name", 20.4)
  val res = convertTuple(tpl._1, tpl._2)
  println(res)
}
