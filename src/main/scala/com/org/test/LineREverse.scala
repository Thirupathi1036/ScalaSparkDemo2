package com.org.test

object LineREverse extends App {

  val str = "The lines are printed in reverse? order?"



  rever(str)

  def rever(str: String) = {
    //if(str.matches("[A-Za-z]")){
    val spl=str.substring(str.length-1,str.length)
    val words=str.substring(0,str.length-1)
    println(spl+"\t"+words)
      val data = str.replace("[.\\?]","").split(" ").sortBy(e => e.length)
      val data1 = words.split(" ").sortBy(e => e.length)
      val first=data(0).substring(0,1).toUpperCase+data(0).substring(1)
      val res=first+" " +data.tail.mkString(" ").toLowerCase+spl
      println(res)
    //}

  }
}
