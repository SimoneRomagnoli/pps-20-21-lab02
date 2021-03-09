package lab02

import lab02.ExtendedOptionals.Option
import lab02.ExtendedOptionals.Option._
import lab02.HelloScala.parityLambda
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestExtendedOptionals {

  val s0: Option[Int] = None()
  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = Some(3)
  val strue: Option[Boolean] = Some(true)
  val sfalse: Option[Boolean] = Some(false)

  val isEven: Int => Boolean = _%2==0
  val greaterThanTwo: Int => Boolean = _>2

  val parity = HelloScala

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

}
