package de.htwg.se.Chess.model.gridComponent

import de.htwg.se.Chess.model.figureComponent.{Color, Figure}
import de.htwg.se.Chess.model.gridComponent.gridBaseImpl.Matrix

trait GridInterface {

  def size: Int

  def cell(row: Int, col: Int): CellInterface
  def set(row: Int, col: Int, value: Option[Figure]): GridInterface
  def fill(): GridInterface

  var isInCheckColor: Color.Value
  def isInCheck(colorToCheck: Color.Value): Boolean
  def getAllOtherColorAndCheck(kingPos: (Int, Int), revColor: Color.Value, gridC: GridInterface): Boolean

}

trait GridFactory {

  def create(size: Int): GridInterface
  def create(cells: Matrix[CellInterface]): GridInterface

}

trait CellFactory {

  def create(status: Option[Figure]): CellInterface

}

trait CellInterface {

  def value: Option[Figure]
  def isSet: Boolean

}