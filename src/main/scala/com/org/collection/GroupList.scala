package com.org.collection

import scala.collection.mutable.ListBuffer

object GroupList extends App {

  val str = "04 90-569  728?190"

  val result = groupData(str, 5)
  println(result)

  def groupData(s: String, groupSize: Int): String = {
    val numStr = s.replaceAll("\\s+", "").replaceAll("[^0-9]", "").split("")
    group(numStr, groupSize)
  }

  private def group(numStrList: Array[String], groupSize: Int): String = {

    val lb = new ListBuffer[String]
    val sb = new StringBuilder()

    var count = 0
    for (i <- numStrList.indices) {
      lb.append(numStrList(i))
      count = count + 1
      if (count % groupSize == 0) {
        sb.append(lb.mkString).append("-")
        lb.clear()
      }
      if (i == numStrList.size - 1) {
        if (lb.size == 1) {
          val tmp = sb.charAt(sb.length - 2) + lb.mkString
          sb.replace(sb.length - 2, sb.length - 1, "").append(tmp)
        } else if (count % groupSize >= 1) {
          sb.append(lb.mkString)
        }
      }
    }
    val sss=sb.toString()
    if(sss.endsWith("-"))sss.substring(0,sss.length-1) else sss
  }
}
