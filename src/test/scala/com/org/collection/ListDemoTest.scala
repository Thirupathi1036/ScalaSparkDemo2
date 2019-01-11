package com.org.collection

import org.junit._
import Assert._

@Test
class ListDemoTest {

  @Test
  def testList() = {
    val actualRes = ListDemo.getList("hi,how")
    val expectedRes = List("hi", "how")

    assertEquals(expectedRes, actualRes)
  }
}
