package lab02

object HelloScala extends App {

  val parityLambda: Int => String = {
    case x if x % 2 == 0 => "even"
    case _ => "odd"
  }

  def parityMethod(x: Int): String = x match {
    case _ if x % 2 == 0 => "even"
    case _ => "odd"
  }

  println(parityLambda(2))
  println(parityMethod(2))

}
