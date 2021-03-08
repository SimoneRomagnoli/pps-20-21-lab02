package lab02

object ComposeFunctions {

  def compose(f: Int => Int, g: Int => Int): Int => Int = input => f(g(input))

  def genericsCompose[T](f:T=>T, g:T=>T): T => T = input => f(g(input))

}
