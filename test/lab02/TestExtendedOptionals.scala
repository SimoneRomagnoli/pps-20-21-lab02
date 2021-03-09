package lab02

import lab02.ExtendedOptionals.Option
import lab02.ExtendedOptionals.Option._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestExtendedOptionals {

  val s0: Option[Int] = None()
  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = Some(3)
  val onePlusThree = 4

  val isEven: Int => Boolean = _%2==0
  val greaterThanTwo: Int => Boolean = _>2
  val sum: (Int, Int) => Int = _+_
  val areMultiples: (Int, Int) => Boolean = (a, b) => a%b==0 || b%a==0

  @Test def testFilter(): Unit = {
    assertEquals(true, isEmpty(filter(s0)(greaterThanTwo)))
    assertEquals(true, isEmpty(filter(s2)(greaterThanTwo)))
    assertEquals(false, isEmpty(filter(s3)(greaterThanTwo)))
  }

  @Test def testFilterDoesNotChangeContent(): Unit = {
    assertEquals(getOrElse(s3, 0), getOrElse(filter(s3)(greaterThanTwo), 0))
  }

  @Test def testMap(): Unit = {
    assertEquals(true, isEmpty(map(s0)(isEven)))
    assertEquals(false, getOrElse(map(s1)(isEven), 0))
    assertEquals(false, isEmpty(map(s2)(isEven)))
    assertEquals(true, getOrElse(map(s2)(isEven), 0))
  }

  @Test def testMap2(): Unit = {
    assertEquals(true, isEmpty(map2(s0)(s1)(sum)))
    assertEquals(onePlusThree, getOrElse(map2(s1)(s3)(sum), 0))
    assertEquals(false, getOrElse(map2(s2)(s3)(areMultiples), 0))
    assertEquals(true, getOrElse(map2(s1)(s3)(areMultiples), 0))
  }

}
