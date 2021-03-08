package lab02

import lab02.Shapes._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestShapes {

  val height = 10.0
  val width = 20.0

  @Test def testRectangle(): Unit = {
    val rect:Shape = Rectangle(height, width)
    assertEquals(60, perimeter(rect))
  }
}
