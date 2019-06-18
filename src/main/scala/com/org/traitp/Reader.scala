package com.org.traitp


trait Reader[T] {
  def convert(s: String): T
}
