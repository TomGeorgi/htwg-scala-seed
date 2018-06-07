package de.htwg.se.Chess.model

case class Bishop(c: Color.Value) extends Figure {

  override val color: Color.Value = c
  override val typ: FigureType.Value = FigureType.BISHOP

  override def move(oldRow: Int, oldCol: Int, newRow: Int, newCol: Int, grid: Grid): Boolean = {
    val revColor = colorReverse(color)
    val moves = (-1, -1) :: (-1, 1) :: (1, -1) :: (1, 1) :: Nil

    for (i <- moves) {
      for (j <- 1 to 8) {
        val move: (Int, Int) = (oldRow + i._1 * j, oldCol + i._2 * j)
        if (move._1 < 8 && move._2 < 8 && move._1 >= 0 && move._2 >= 0) {
          if (move == (newRow, newCol)) {
            if(!wayIsBlocked((oldRow, oldCol), (newRow, newCol), i, grid)) {
              if (grid.cell(move._1, move._2).isSet) {
                grid.cell(move._1, move._2).value match {
                  case Some(res) => res.color match {
                    case `color` => return false
                    case `revColor` => return true
                  }
                  case None => return true
                }
              } else return true
            } else return false
          }
        }
      }
    }
    false
  }

  def wayIsBlocked(oldPlace: (Int, Int), newPlace: (Int, Int), direction: (Int, Int), grid: Grid): Boolean = {
    val len: Int = oldPlace._1 - newPlace._1
    for (i <- 1 until len) {
      val move: (Int, Int) = (oldPlace._1 + direction._1 * i, oldPlace._2 + direction._2 * i)
      if(grid.cell(move._1, move._2).isSet) return true
    }
    false
  }

  override def colorReverse(color: Color.Value): Color.Value = color match {
    case Color.WHITE => Color.BLACK
    case Color.BLACK => Color.WHITE
  }

  override def toString: String = {
    color match {
      case Color.BLACK => "♝"
      case Color.WHITE => "♗"
    }
  }

}
