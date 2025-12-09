package com.knowingwhere.aoc2025.utils

import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class GridTest extends AnyWordSpec with BeforeAndAfterEach {
  "Grid" should {
    "replace the items specified in an array from given positions" in {
      val testInput =
        """..@@.
          |@@@.@
          |@@@@@
          |@.@@@
          |@@.@@""".stripMargin
      val grid = Grid(testInput.linesIterator.toList)
      val newGrid = grid.putElements(List(Position(0,2), Position(2,1)), ".")
      newGrid.gridElements.head shouldBe "...@."
    }
  }
}
