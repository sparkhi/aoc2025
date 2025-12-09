package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.{Grid, Position}

import scala.annotation.tailrec
import scala.io.Source

object Day4:
  def main(args: Array[String]): Unit = {
    val grid = Grid(Source.fromResource("day4-input.txt").getLines().toList)
    val totalRows = grid.getMaxRow
    val totalCols = grid.getMaxCol

    val allPositions = (for {
      row <- 0 to totalRows
      col <- 0 to totalCols
    } yield Position(row, col)).toList

    val rollPositions = allPositions.filter(grid.getItemAt(_) == "@")
    val surroundingCounts = rollPositions.count(Day4.findCountOfAdjacentRolls(grid, _) < 4)
    println(surroundingCounts)

    val recursiveCount = runRecursiveRemoval(grid, allPositions, 0)
    println(recursiveCount)
  }

  @tailrec
  private def runRecursiveRemoval(grid: Grid, allPositions: List[Position], accumulatedCount: Int): Int = {
    val rollPositions = allPositions.filter(grid.getItemAt(_) == "@")
    val canBeRemoved = rollPositions.filter(Day4.findCountOfAdjacentRolls(grid, _) < 4)
    val canBeRemovedCount = canBeRemoved.size
    canBeRemovedCount match {
      case 0 => accumulatedCount
      case _ =>
        val newGrid = grid.putElements(canBeRemoved, ".")
        runRecursiveRemoval(newGrid, allPositions, accumulatedCount + canBeRemovedCount)
    }
  }

  def findCountOfAdjacentRolls(grid: Grid, aroundPos: Position): Int = {
    val maxPos = Position(grid.getMaxRow, grid.getMaxCol)
    val adjacentPositions: List[Position] = aroundPos.getAdjacentPositionsUptoMax(maxPos)
    adjacentPositions.count(grid.getItemAt(_) == "@")
  }

