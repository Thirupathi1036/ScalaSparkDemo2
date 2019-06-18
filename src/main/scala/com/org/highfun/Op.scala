package com.org.highfun

trait Op[A] {

  def oper[B](a: A, b: A, f: (A, A) => B): B
}

object Op extends Op[String]{
  override def oper[B](a: String, b: String, f: (String, String) => B): B = f(a, b)
}

object TestOp extends App {
  println(Op.oper("a", "b", (a, b) => a + b))
}
