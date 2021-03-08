package u02

object HelloScala extends App {

    val parityLambda: Int => String = {
      case x if x % 2 == 0 => "even"
      case _ => "odd"
    }

    def parityMethod(x:Int): String = x match {
      case _ if x % 2 == 0 => "even"
      case _ => "odd"
    }

    println(parityLambda(2))
    println(parityMethod(2))

    val negative: (String => Boolean) => (String => Boolean) = predicate => predicate match {
      case _ => !predicate(_)
    }

    def neg(predicate:String => Boolean):(String => Boolean) = predicate match {
      case _ => !predicate(_)
    }

    val empty: String => Boolean = _==""
    val notEmpty = neg(empty)
    println(notEmpty("foo"))
    println(notEmpty(""))

    def genericsNeg[T](predicate:T => Boolean):(T => Boolean) = predicate match {
      case _ => !predicate(_)
    }

  val even: Int => Boolean = _%2==0
  val odd = genericsNeg(even)

  println(odd(3))

}
