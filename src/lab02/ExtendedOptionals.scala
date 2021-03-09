package lab02

object ExtendedOptionals extends App {

  sealed trait Option[A] // An Optional data type
  object Option {
    case class None[A]() extends Option[A]
    case class Some[A](a: A) extends Option[A]

    def isEmpty[A](opt: Option[A]): Boolean = opt match {
      case None() => true
      case _ => false
    }

    def getOrElse[A, B >: A](opt: Option[A], orElse: B): B = opt match {
      case Some(a) => a
      case _ => orElse
    }

    def flatMap[A,B](opt: Option[A])(f:A => Option[B]): Option[B] = opt match {
      case Some(a) => f(a)
      case _ => None()
    }

    def filter[A](opt:Option[A])(predicate:A => Boolean):Option[A] = opt match {
      case Some(a) if predicate(a) => opt
      case _ => None()
    }

    def map[A, B](opt: Option[A])(transform:A => B): Option[B] = opt match {
      case Some(a) => Some(transform(a))
      case _ => None()
    }

    def map2[A, B, C](opt1: Option[A])(opt2: Option[B])(transform:(A , B) => C): Option[C] = opt1 match {
      case Some(a) => opt2 match {
        case Some(b) => Some(transform(a,b))
        case _ => None()
      }
      case _ => None()
    }
  }

}
