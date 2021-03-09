package lab02

object ComposeFunctions {

  def compose(f: Int => Int, g: Int => Int): Int => Int = input => f(g(input))

  def genericsCompose[A,B,C](f:B=>C, g:A=>B): A => C = input => f(g(input))

}
