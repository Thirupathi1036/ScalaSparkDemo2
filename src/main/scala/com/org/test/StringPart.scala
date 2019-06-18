package com.org.test

object StringPart {

  def main(args: Array[String]): Unit = {

    val str="0 44-2   456780?  - ."
    splitString(str)
  }

  def splitString(s:String):String={
    val repStr=s.replaceAll("[^0-9]","")
    println(repStr.grouped(3).mkString("-"))
    //repStr.grouped(3)

    ""
  }

}
