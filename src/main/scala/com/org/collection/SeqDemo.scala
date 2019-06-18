package com.org.collection

import scala.collection.mutable.ListBuffer

object SeqDemo extends App {
  val ml =ListBuffer.empty[String]
  ml.append("hai")
  ml.append("wel")
  ml+="emp"
  println(ml.toList)
  val rr=ml.reduce(_+_)
println(rr)

  val ll=List("hh","dd")
  println(ll)

  //val res=ml++ll
  val res=ml++ll
  println(res)
}
