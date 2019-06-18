package com.org.impli

trait Read[T] {
  def read(x: String): T
}

object StringToAny {
  implicit val stringToInt = new Read[Int] {
    override def read(x: String): Int = x.toInt
  }

  //def reader(T:Read):T=implicitly[Read[T]]
}
