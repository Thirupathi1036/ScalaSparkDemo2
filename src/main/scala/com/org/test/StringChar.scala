package com.org.test

object StringChar extends App {

  checkDuplicatesChar("Java")
  checkDuplicatesChar("Programming")
  def checkDuplicatesChar(s:String)={
    val charList=s.toList.groupBy(w=>w).mapValues(_.size).filter(_._2>=2)
    println(charList)
  }
}
