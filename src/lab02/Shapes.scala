package lab02

object Shapes {

  val pi =3.14

  sealed trait Shape
  case class Rectangle(height:Double, width:Double) extends Shape
  case class Circle(radius:Double) extends Shape
  case class Square(edge:Double) extends Shape

  def perimeter(s:Shape): Double = s match {
    case Rectangle(h, w) => h*2 + w*2
    case Circle(r) => 2*pi*r
    case Square(e) => 4*e
  }

}
