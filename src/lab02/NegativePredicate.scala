package lab02

object NegativePredicate {

  val valNeg: (String => Boolean) => (String => Boolean) = predicate => predicate match {
    case _ => !predicate(_)
  }

  def methodNeg(predicate: String => Boolean): (String => Boolean) = predicate match {
    case _ => !predicate(_)
  }

  def genericsNeg[T](predicate: T => Boolean): (T => Boolean) = predicate match {
    case _ => !predicate(_)
  }
}
