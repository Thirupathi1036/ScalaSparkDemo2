package com.org.func

import com.org.traitp.Loader

object Loader extends App {

  implicit val stringToInt = new Loader[String, Int] {
    override def load(a: String): Int = a.toInt
  }
  /*implicit val stringToPrint = new Loader[String, Unit] {
    override def load(a: String): Unit = println(a)
  }*/

  implicit val intToDouble = new Loader[Int, Double] {
    override def load(a: Int): Double = a.toDouble
  }

  def loadLoader[A, B](x: A)(implicit loader: Loader[A, B]): B = loader.load(x)

  val stringToIntLoader = loadLoader("123")(stringToInt)
  //val intToDouble = loadLoader[Int, Double]
  println(stringToIntLoader)

}
