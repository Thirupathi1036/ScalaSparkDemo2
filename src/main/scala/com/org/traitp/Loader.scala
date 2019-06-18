package com.org.traitp

trait Loader[A, B] {

  def load(a: A): B
}
