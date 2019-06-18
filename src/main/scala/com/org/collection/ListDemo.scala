package com.org.collection

object ListDemo extends App {

  val list = List(1, 2, 3)
  //println(list.lift(6))
  //println(list(2))
  //println(list.indexOf(3))
  //println(list.slice(1, 2))

  val dropList = list.drop(1)
  println(dropList)


  val splitList = list.splitAt(3)

  println(splitList)
  val dropWhile = list.dropWhile(e => e != 2)
  println("drop While: " + dropWhile)

  val fold = list.fold(0)((a, b) => a + b)
  println("Fold: " + fold)

  val foldLeft = list.foldLeft(0)((a, b) => a + b)
  println("Fold Left: " + foldLeft)

  val foldRight = list.foldRight(0)((x, y) => x + y)
  println("Fold Right: " + foldRight)

  def getList(str: String): List[String] = str.split(",").toList

}
