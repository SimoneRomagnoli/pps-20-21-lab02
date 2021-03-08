package lab02

import lab02.Shapes._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestShapes {

  val height = 10.0
  val width = 20.0
  val rectPerimeter = 60
  val rectArea = 200

  val radius = 100.0
  val circPerimeter = 628
  val circArea = 31400

  val edge = 50.0
  val squarePerimeter = 200
  val squareArea = 2500

  @Test def testRectangle(): Unit = {
    val rect:Shape = Rectangle(height, width)
    assertEquals(rectPerimeter, perimeter(rect))
    assertEquals(rectArea, area(rect))
  }

  @Test def testCircle(): Unit = {
    val circ:Shape = Circle(radius)
    assertEquals(circPerimeter, perimeter(circ))
    assertEquals(circArea, area(circ))
  }

  @Test def testSquare(): Unit = {
    val square:Shape = Square(edge)
    assertEquals(squarePerimeter, perimeter(square))
    assertEquals(squareArea, area(square))
  }

}
