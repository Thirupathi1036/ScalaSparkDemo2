package com.org.test

object StringAnagram extends App {

  val str1 = "listen"
  val str2 = "silent"

  //println("before sort: " + str1)
  //println("after sort: " + sortString(str1))
  // println("before sort: " + str2)
  // println("after sort: " + sortString(str2))

  checkAnagram(str1, str2)

  checkAnagram("hello", "hai")
  checkAnagram("hel", "wel")


  println(sortString("cvabc"))
  def checkAnagram(str1: String, str2: String): Unit = {
    if (str1.length != str2.length) println("Not Anagram")
    else {
      val sort1 = sortString(str1)
      val sort2 = sortString(str2)
      println(s"str1: $sort1 and Str2: $sort2")
      if (sort1.equalsIgnoreCase(sort2)) println("Anagram String")
      else println("Not Angram")
    }
  }

  def sortString(str: String): String = {
    val inStr = str.toCharArray
    for (i <- 0 until inStr.length) {
      //var tmp: Char = '''
      for (j <- i until inStr.length) {
        if (inStr(i) > inStr(j)) {
          val tmp:Char = inStr(i)
          inStr(i) = inStr(j)
          inStr(j) = tmp
        }
      }
    }
    return new String(inStr)
  }
}
