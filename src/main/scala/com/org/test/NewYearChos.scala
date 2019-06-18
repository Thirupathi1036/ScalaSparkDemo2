package com.org.test

object NewYearChos extends App {

  val ar = Array(1,2,5,3,4,7,8,6)
  val a1 = Array(1, 2, 3)
  val res = getPath(ar, 2)

  println(res.toList)

  def getPath(q: Array[Int], times: Int): Array[Int] = {
    var count=0
    var i=q.length-1
    while(i>0){
      val j=i
      val k=if((i-1)<0)0 else i-1
      swap(q,j,k)
      count=count+1
      if(count%2==0) i=i-2 else i=i-1
    }
    println(count)
    q
  }

  def swap(sa: Array[Int],sourceIndex:Int,destIndex:Int):Array[Int] = {
    val tmp=sa(sourceIndex)
    sa(sourceIndex)=sa(destIndex)
    sa(destIndex)=tmp
    sa
  }
}
