package lab02

object CurryingPredicate {

  def methodCurriedPred(x:Double)(y:Double)(z:Double): Boolean = x match {
    case x if x <= y => y <= z
    case _ => false
  }

  def methodNonCurriedPred(x:Double, y:Double, z:Double):Boolean = x <= y && y <= z

  val valNonCurriedPred:(Double, Double, Double) => Boolean = (x:Double, y:Double, z:Double) => x <= y && y <= z

  val valCurriedPred: Double => Double => Double => Boolean = x => y => z => x<=y && y<=z
}
