package de.htwg.se.Chess.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class CellSpec extends WordSpec with Matchers {

  "A Cell" when {
    "not set to any value" should {
      val emptyCell = Cell(None)
      "have value None" in {
        emptyCell.value should be(None)
      }
      "not be set" in {
        emptyCell.isSet should be(false)
      }
    }
    "set to a specific value" should {
      val nonEmptyCell = Cell(Some(Pawn(Color.WHITE)))
      "return that value" in {
        nonEmptyCell.value should be(Some(Pawn(Color.WHITE)))
      }
      "be set" in {
        nonEmptyCell.isSet should be(true)
      }
    }
  }
}
