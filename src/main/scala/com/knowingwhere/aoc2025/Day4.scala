package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.{Grid, Position}

import scala.io.Source

object Day4:
  def main(args: Array[String]): Unit = {
    val grid = Grid(Source.fromResource("day4-input.txt").getLines().toList)
    val totalRows = grid.gridElements.size - 1
    val totalCols = grid.gridElements.head.length - 1

    val allPositions = (for {
      row <- 0 to totalRows
      col <- 0 to totalCols
    } yield (Position(row, col))).toList

    val rollPositions = allPositions.filter(grid.getItemAt(_) == "@")
    val surroundingCounts = rollPositions.count(Day4.findCountOfAdjacentRolls(grid, _) < 4)

    println(surroundingCounts)
  }

  def findCountOfAdjacentRolls(grid: Grid, aroundPos: Position): Int = {
    val maxPos = Position(grid.gridElements.size - 1, grid.gridElements.head.length - 1)
    val adjacentPositions: List[Position] = aroundPos.getAdjacentPositionsUptoMax(maxPos)
    adjacentPositions.count(grid.getItemAt(_) == "@")
  }

