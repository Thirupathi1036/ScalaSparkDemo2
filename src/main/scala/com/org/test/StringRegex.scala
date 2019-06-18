package com.org.test

object StringRegex {

  def main(args: Array[String]): Unit = {
    val str="Hello spark scala > ? welcome ., to ; welcome 12345  789^&#@"
    stringAlpha(str)
    stringNum(str)
    stringAlphaNum(str)
  }

  def stringAlpha(s:String)={
    val res=s.replaceAll("[^a-zA-Z\\s+]","")
    println(res)
  }
  def stringNum(s:String): Unit ={

    val num=s.replaceAll("[^0-9]","").trim
    println(num)
  }
  def stringAlphaNum(s:String)={
    val alphaNum=s.replaceAll("[^a-zA-Z0-9\\s+]","")
    println(alphaNum)
  }
}
