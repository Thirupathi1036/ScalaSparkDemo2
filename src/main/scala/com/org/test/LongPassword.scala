package com.org.test

object LongPassword extends App {

  val str="test 5 a0A pass007 ?xy1    hello"
  val words=str.replaceAll("\\s+"," ").split(" ").toList
  //val words=s.replaceAll("\\s+","").split(" ")
  val numList=words.filter(e=>e.matches("^[0-9a-zA-Z]*$") &&
    e.replaceAll("[0-9]+","").length%2==0 &&
    e.replaceAll("[a-zA-Z]+","").length%2==1).map(_.size)
  val max= if(numList.isEmpty) -1 else numList.max
  println(max)

}
