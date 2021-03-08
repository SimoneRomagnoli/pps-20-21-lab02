package lab02

object Shapes {

  sealed trait Shape
  case class Rectangle(height:Double, width:Double) extends Shape
  case class Circle(radius:Double) extends Shape
  case class Square(edge:Double) extends Shape


}
