package lab02

object BTreesTraversal extends App {

  // A custom and generic binary tree of elements of type A
  sealed trait Tree[A]
  object Tree {
    case class Leaf[A](value: A) extends Tree[A]
    case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

    def traversal[A,B](t:Tree[A])(op:(B, B)=>B)(leafOp:A=>B):B = t match {
      case Branch(l,r) => op(traversal(l)(op)(leafOp), traversal(r)(op)(leafOp))
      case Leaf(v) => leafOp(v)
    }

    def size[A](t: Tree[A]): Int =
      traversal(t)((a:Int, b:Int) => a+b)(_ => 1)

    def find[A](t: Tree[A], elem: A): Boolean =
      traversal(t)((a:Boolean, b:Boolean) => a||b)(_==elem)

    def count[A](t: Tree[A], elem: A): Int =
      traversal(t)((a:Int, b:Int) => a+b)(_ match {
        case e if e == elem => 1
        case _ => 0
      })
  }
}
