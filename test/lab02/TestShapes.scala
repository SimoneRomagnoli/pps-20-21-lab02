package lab02

import lab02.Shapes._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestShapes {

  val height = 10.0
  val width = 20.0
  val radius = 100.0
  val edge = 50.0

  @Test def testRectangle(): Unit = {
    val rect:Shape = Rectangle(height, width)
    assertEquals(60, perimeter(rect))
    assertEquals(200, area(rect))
  }

  @Test def testCircle(): Unit = {
    val circ:Shape = Circle(radius)
    assertEquals(628, perimeter(circ))
    assertEquals(31400, area(circ))
  }

  @Test def testSquare(): Unit = {
    val square:Shape = Square(edge)
    assertEquals(200, perimeter(square))
    assertEquals(2500, area(square))
  }

}
