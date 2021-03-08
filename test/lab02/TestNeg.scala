package lab02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestNeg {

  val neg = NegativePredicate
  val empty:String => Boolean = _==""
  val oddNumber = 31
  val evenNumber = 42

  @Test def testValNeg(): Unit = {
    val notEmpty = neg.valNeg(empty)
    assertEquals(true, notEmpty("foo"))
  }

  @Test def testMethodNeg(): Unit = {
    val notEmpty = neg.methodNeg(empty)
    assertEquals(true, notEmpty("foo"))
  }

  @Test def testGenericsNeg(): Unit = {
    val even:Int => Boolean = _%2==0
    val odd = neg.genericsNeg(even)
    assertEquals(true, odd(oddNumber))
    assertEquals(false, odd(evenNumber))
  }

}
