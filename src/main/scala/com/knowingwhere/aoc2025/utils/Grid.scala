package com.knowingwhere.aoc2025.utils

import scala.annotation.tailrec

case class Grid(gridElements: List[String]) {
  def getItemAt(pos: Position): String = {
    gridElements(pos.row)(pos.col).toString
  }

  def getMaxRow: Int = {
    gridElements.size - 1
  }

  def getMaxCol: Int = {
    gridElements.head.length - 1
  }

  def putElements(positions: List[Position], item: String): Grid = {
    val newElementsList = replace(gridElements, positions, 0, item, List.empty)
    Grid(newElementsList)
  }

  @tailrec
  private def replace(remainingElements: List[String], positions: List[Position], rowNum: Int, item:String, accumulatedElements: List[String]) : List[String] = {
    remainingElements match {
      case Nil => accumulatedElements
      case _ =>
        val currentLine = remainingElements.head
        val positionsInRow = positions.filter(_.row == rowNum)
        val updated = replaceChars(currentLine, positionsInRow, item)
        replace(remainingElements.tail, positions, rowNum + 1, item, accumulatedElements :+ updated)
    }
  }

  private def replaceChars(original: String, positionsInRow: List[Position], item: String) = {
    val arr = original.toCharArray
    positionsInRow.map(_.col).foreach { i =>
      if i >= 0 && i < arr.length then
        arr(i) = item.head
    }
    new String(arr)
  }
}

case class GridElement(pos: Position, item: String)
