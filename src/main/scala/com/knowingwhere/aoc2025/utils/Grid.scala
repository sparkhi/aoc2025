package com.knowingwhere.aoc2025.utils

case class Grid(gridElements: List[String]) {
  def getItemAt(pos: Position): String = {
    gridElements(pos.row)(pos.col).toString
  }
}

case class GridElement(pos: Position, item: String)
