package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.{Grid, GridElement, Position}
import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class Day4Test extends AnyWordSpec with BeforeAndAfterEach {

  var grid: Grid = LoadGrid()

  override def beforeEach(): Unit = {
    super.beforeEach()
  }

  def LoadGrid(): Grid = {
    val testInput =
      """..@@.@@@@.
        |@@@.@.@.@@
        |@@@@@.@.@@
        |@.@@@@..@.
        |@@.@@@@.@@
        |.@@@@@@@.@
        |.@.@.@.@@@
        |@.@@@.@@@@
        |.@@@@@@@@.
        |@.@.@@@.@.""".stripMargin

    Grid(testInput.linesIterator.toList)
  }

  override def afterEach(): Unit = {
    super.afterEach()
  }

  "Day 4" should {
    "return correct count of rolls based on the position in grid" in {
      Day4.findCountOfAdjacentRolls(grid, Position(0, 0)) shouldBe 2
      Day4.findCountOfAdjacentRolls(grid, Position(1, 2)) shouldBe 6
      Day4.findCountOfAdjacentRolls(grid, Position(4, 4)) shouldBe 8
      Day4.findCountOfAdjacentRolls(grid, Position(7, 0)) shouldBe 2
      Day4.findCountOfAdjacentRolls(grid, Position(0, 9)) shouldBe 3
    }

    "count of rolls possible" in {
      val totalRows = grid.gridElements.size - 1
      val totalCols = grid.gridElements.head.length - 1

      val positions = (for {
        row <- 0 to totalRows
        col <- 0 to totalCols
      } yield Position(row, col)).toList
      positions.size shouldBe 100
      val rollPositions = positions.filter(grid.getItemAt(_) == "@")
      val surroundingCounts = rollPositions.count(Day4.findCountOfAdjacentRolls(grid, _) < 4)
      surroundingCounts shouldBe 13
    }
  }
}
