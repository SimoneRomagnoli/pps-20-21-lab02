package lab02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestCompose {

  val compose = ComposeFunctions

  val increment:Int => Int = _+1
  val timesTwo:Int => Int = _*2
  val input = 42
  val output = 85

  val not:Boolean => Boolean = !_
  val useless:Boolean => Boolean = _ || false

  @Test def testCompose(): Unit = {
    assertEquals(output, compose.compose(increment, timesTwo)(input))
  }

  @Test def testGenericsCompose(): Unit = {
    assertEquals(output, compose.genericsCompose(increment, timesTwo)(input))
    assertEquals(true, compose.genericsCompose(not, useless)(false))
  }
}
