package u02

object Currying extends App {

  // standard function with no currying
  def mult(x: Double, y: Double): Double = x*y

  // function with currying
  // curriedMult has actually type: Double => (Double => Double)
  def curriedMult(x: Double)(y: Double): Double = x*y

  //function type is Double => Double => Double => Boolean
  def curriedPred(x:Double)(y:Double)(z:Double): Boolean = x match {
    case x if x <= y => y <= z
    case _ => false
  }

  def nonCurriedPred(x:Double, y:Double, z:Double):Boolean = x <= y && y <= z

  val valNonCurriedPred:(Double, Double, Double) => Boolean = (x:Double, y:Double, z:Double) => x <= y && y <= z

  val valCurriedPred: Double => Double => Double => Boolean = x => y => z => x<=y && y<=z

  println("Method curried pred is "+curriedPred(5.0)(10.0)(20.0))
  println("Method non curried pred is "+nonCurriedPred(5.0,10.0,20.0))
  println("Val curried pred is "+valCurriedPred(5.0)(10.0)(20.0))
  println("Val non curried pred is "+valNonCurriedPred(5.0,10.0,20.0))

  // slightly different syntax at the call side..
  println(mult(10,2)) // 20
  println(curriedMult(10)(2)) // 20

  // curriedMult can be partially applied!
  val twice: Double => Double = curriedMult(2)

  println(twice(10)) // 20

  // => is right-associative, hence it is equal to:
  //val curr...: Double => (Double => Double) = x => (y => x*y)
  val curriedMultAsFunction: Double => Double => Double = x => y => x*y

  println(curriedMultAsFunction(10)(2)) // 20
  println(curriedMultAsFunction) // u02.Currying$$$Lambda$7/...
  println(curriedMultAsFunction(10)) // u02.Currying$$$Lambda$12/...

}
