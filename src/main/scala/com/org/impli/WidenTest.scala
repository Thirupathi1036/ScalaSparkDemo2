package com.org.impli

object WidenTest extends App {

  def widen[T, V](x: T)(implicit widener: Widener[T, V]): V = widener.widen(x)

  println(widen("123"))
}
