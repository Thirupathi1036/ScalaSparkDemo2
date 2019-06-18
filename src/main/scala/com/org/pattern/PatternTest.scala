package com.org.pattern

import com.org.model.{Employee, Person}

object PatternTest extends App {

  val per = Person(123, "abc", null)
  val emp = Employee
  per match {
    case Person(id, name, dob) => println("Id: " + id + "Name: " + name)
    case e: Employee => println("Employee")
    case _ => println("nothing")
  }
}
