package com.knowingwhere.aoc2025.utils

/**
 * Operates in screen coordiantes, top-left is (0,0), row increasing vertically, col increasing horizontally
 * @param row X coordinate
 * @param col Y coordinate
 */
case class Position (row: Int, col: Int) {
  require(row >= 0)
  require(col >= 0)

  def getAdjacentPositionsUptoMax(maxPosition: Position): List[Position] = {
    (for {
      rowIndex <- (row - 1 to row + 1).filter(item =>  item >= 0 && item <= maxPosition.row)
      colIndex <- (col - 1 to col + 1).filter(item =>  item >= 0 && item <= maxPosition.col)
      if !(rowIndex == row && colIndex == col)
    } yield Position(rowIndex,colIndex)).toList
  }
}
