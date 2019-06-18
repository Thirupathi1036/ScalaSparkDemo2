package com.org.file

object FileUtils {

  def getResourcePath(path: String = "/") = getClass.getResource(path).getPath

}
