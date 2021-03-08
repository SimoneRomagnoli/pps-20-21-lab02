package lab02

object Fibonacci {
  def fib(n:Int):Int = {
    @annotation.tailrec
    def _fib(n:Int, first:Int, second:Int): Int = n match {
      case 0 => first
      case 1 => second
      case _ => _fib(n-1, second, first+second)
    }
    _fib(n, 0, 1)
  }
}
