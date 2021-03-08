package lab02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestFibonacci {

  val fib = Fibonacci
  val number = 13
  val fibSeq = 233

  @Test def testCompose(): Unit = {
    assertEquals(fibSeq, fib.fib(number))
  }

}
