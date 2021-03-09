package lab02

import lab02.ExtendedOptionals.Option
import lab02.ExtendedOptionals.Option._

import lab02.Shapes._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestExtendedOptionals {

  val s0: Option[Int] = None()
  val s1: Option[Int] = Some(1)
  val s2: Option[Int] = Some(2)
  val s3: Option[Int] = Some(3)
  val strue: Option[Boolean] = Some(true)
  val sfalse: Option[Boolean] = Some(false)

  @Test def testFilter(): Unit = {
    assertEquals(true, isEmpty(filter(s2)(_>2)))
    assertEquals(false, isEmpty(filter(s3)(_>2)))
  }

  @Test def testFilterDoesNotChangeContent(): Unit = {
    assertEquals(getOrElse(s3, 0), getOrElse(filter(s3)(_>2), 0))
  }

}
