package com.org.func

import com.org.traitp.Reader

object Reader {

  implicit val doubleReader = new Reader[Double] {
    override def convert(s: String): Double = s.toDouble
  }

  implicit val stringReader = new Reader[String] {
    override def convert(s: String): String = s.toString
  }

  implicit val intReader = new Reader[Int] {
    override def convert(s: String): Int = s.toInt
  }

  def converter[T: Reader]: String => T = implicitly[Reader[T]].convert

  val stringConverter = converter[String]
  val doubleConverter = converter[Double]
  val intConverter = converter[Int]

  println(stringConverter("hey welocme"))
  println(doubleConverter("123.0009"))
  println(intConverter("4000"))
}
