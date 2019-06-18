package com.org.impli

class Widener[T, V](val widen: T => V)

object Widener {

  implicit object FloatWiden extends Widener[Float, Double](_.toDouble)

  implicit object StringWiden extends Widener[String, Int](_.toInt)

}

