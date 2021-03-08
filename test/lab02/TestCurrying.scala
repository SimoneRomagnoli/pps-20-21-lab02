package lab02

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class TestCurrying {

  val preds = CurryingPredicate
  val small = 1
  val medium = 2
  val large = 3

  @Test def testCurriedMethodPredicate(): Unit = {
    assertEquals(true, preds.methodCurriedPred(small)(medium)(large))
    assertEquals(true, preds.methodCurriedPred(small)(small)(small))
    assertEquals(false, preds.methodCurriedPred(medium)(small)(large))
  }

  @Test def testNonCurriedMethodPredicate(): Unit = {
    assertEquals(true, preds.methodNonCurriedPred(small, medium, large))
    assertEquals(true, preds.methodNonCurriedPred(small, small, small))
    assertEquals(false, preds.methodNonCurriedPred(medium, small, large))
  }

  @Test def testCurriedValPredicate(): Unit = {
    assertEquals(true, preds.valCurriedPred(small)(medium)(large))
    assertEquals(true, preds.valCurriedPred(small)(small)(small))
    assertEquals(false, preds.valCurriedPred(medium)(small)(large))
  }

  @Test def testNonCurriedValPredicate(): Unit = {
    assertEquals(true, preds.valNonCurriedPred(small, medium, large))
    assertEquals(true, preds.valNonCurriedPred(small, small, small))
    assertEquals(false, preds.valNonCurriedPred(medium, small, large))
  }

}
