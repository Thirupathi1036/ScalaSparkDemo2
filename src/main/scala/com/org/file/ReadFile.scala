package com.org.file

import scala.io.Source

object ReadFile extends App {

  val outFileName = "C:\\Users\\thirupathi.c\\IdeaProjects\\ScalaSparkDemo\\output\\columns.txt"
  val data=Source.fromFile(outFileName).getLines()
  val newData=data.filter(ele=> !ele.contains("element:"))
    .map{ele=> ele.split(":")(0).trim.replaceAll("\\|-- ","")}.toList
    //.replaceAll("\\|    ","")}.toList
  //val newData=data.map{ele=> ele.split(":")(0).replaceAll("\\|-- ","")}.toList
  newData foreach(println)
  val set=newData.toSet.toList
  val diff=newData.diff(set)
  println(diff)
  println(diff.size)
}
