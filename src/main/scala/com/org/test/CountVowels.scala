package com.org.test

object CountVowels extends App {

  val str = "How many vowels in this String"
  countVowels(str)

  def countVowels(s: String) = {
    val char=s.toLowerCase.toList

    var count=0
    char.map{c=> c match {
      case 'a'|'e'|'i'|'o'|'u' => count=count+1
      case _ =>
    }}
    println(count)
  }
}
