package com.org.func

object VaribleArgs extends App {


  def showList(str:Int*)={
    val size=str.size
    size match {
      case 2=>println("Length is 2")
        println(str)
    }
    println(str.size)
    println(str)
  }
  val list1=List(1,2)
  val list2=List(3,4,5,6)
  val list3=List(9,8)
  showList(list1:_*)
  showList(list2:_*)
  showList(list3:_*)


}
