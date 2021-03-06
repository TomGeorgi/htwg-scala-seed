package de.htwg.se.Chess.model.figureComponent

import de.htwg.se.Chess.model.figureComponent.figureBaseImpl.Rook
import de.htwg.se.Chess.model.gridComponent.GridInterface
import de.htwg.se.Chess.model.gridComponent.gridBaseImpl.Grid
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

@RunWith(classOf[JUnitRunner])
class RookSpec extends WordSpec with Matchers {
  var grid: GridInterface = new Grid(8)

  "A Rook" when {
    "set to correct move" should {
      grid = grid.set(0, 0, Some(Rook(Color.BLACK)))
      "have return true" in {
        Rook(Color.BLACK).move(0, 0, 1, 0, grid) should be(true)
      }
    }

    "set to correct move on cell which is filled with an enemy figure" should {
      grid = grid.set(2, 2, Some(Rook(Color.BLACK)))
      grid = grid.set(2, 5, Some(Rook(Color.WHITE)))
      "have return true" in {
        Rook(Color.BLACK).move(2, 2, 2, 5, grid) should be(true)
      }
    }

    "set to invalid move on cell which is filled with the own figure" should {
      grid = grid.set(2, 2, Some(Rook(Color.WHITE)))
      grid = grid.set(2, 5, Some(Rook(Color.WHITE)))
      "have return false" in {
        Rook(Color.WHITE).move(2, 2, 2, 5, grid) should be(false)
      }
    }

    "set to invalid move" should {
      grid = grid.set(0, 1, Some(Rook(Color.BLACK)))
      "have return false" in {
        Rook(Color.BLACK).move(0, 0, 0, 3, grid) should be(false)
      }

      "set to correct attack" should {
        grid = grid.set(0, 2, Some(Rook(Color.WHITE)))
        "have return true" in {
          Rook(Color.BLACK).move(0, 0, 2, 0, grid) should be(true)
        }
      }

      "set to incorrect move" should {
        "have return false" in {
          Rook(Color.BLACK).move(0, 0, 1, 1, grid) should be(false)
        }
      }
      "Set to stay" should {
        "have return false" in {
          Rook(Color.BLACK).move(0, 0, 2, 2, grid) should be(false)
        }
      }
      "set to Empty Cell" should {
        "have return true" in {
          Rook(Color.BLACK).move(0, 0, 1, 0, grid) should be(true)
        }
      }
      "Get All Moves" should {
        var grid: GridInterface = new Grid(8)
        grid = grid.set(3, 3, Some(Rook(Color.WHITE)))
        grid = grid.set(2, 3, Some(Rook(Color.WHITE)))
        grid = grid.set(4, 3, Some(Rook(Color.WHITE)))
        grid = grid.set(3, 1, Some(Rook(Color.WHITE)))
        grid = grid.set(3, 4, Some(Rook(Color.BLACK)))
        "have return" in {
          Rook(Color.WHITE).moveAll(3, 3, grid) should be(List((3,4), (3,2)))
        }
      }
    }
  }
}
