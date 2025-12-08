package com.knowingwhere.aoc2025.utils

import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class PositionTest extends AnyWordSpec {
  "Position" should {
    "return adjacent positions " in {
      //top left
      Position(0,0).getAdjacentPositionsUptoMax(Position(5,5)) shouldBe List(
        Position(0,1),
        Position(1,0), Position(1,1)
      )
      //top edge
      Position(0,3).getAdjacentPositionsUptoMax(Position(5,5)) shouldBe List(
        Position(0,2), Position(0,4),
        Position(1,2), Position(1,3), Position(1,4)
      )
      //top right
      Position(0, 3).getAdjacentPositionsUptoMax(Position(3, 3)) shouldBe List(
        Position(0, 2),
        Position(1, 2), Position(1, 3)
      )
      //left edge
      Position(3, 0).getAdjacentPositionsUptoMax(Position(5, 5)) shouldBe List(
        Position(2,0), Position(2,1),
        Position(3,1),
        Position(4,0), Position(4,1)
      )
      //somewhere in the middle
      Position(1,1).getAdjacentPositionsUptoMax(Position(5,5)) shouldBe List(
        Position(0,0), Position(0,1), Position(0,2),
        Position(1,0), Position(1,2),
        Position(2,0), Position(2,1), Position(2,2)
      )
      //right edge
      Position(3, 5).getAdjacentPositionsUptoMax(Position(5, 5)) shouldBe List(
        Position(2,4), Position(2,5),
        Position(3,4),
        Position(4,4), Position(4,5)
      )
      //bottom left
      Position(5, 0).getAdjacentPositionsUptoMax(Position(5, 5)) shouldBe List(
        Position(4,0), Position(4,1),
        Position(5,1)
      )
      //bottom edge
      Position(5, 3).getAdjacentPositionsUptoMax(Position(5, 5)) shouldBe List(
        Position(4,2), Position(4,3), Position(4,4),
        Position(5,2), Position(5,4)
      )
      //bottom right
      Position(5, 5).getAdjacentPositionsUptoMax(Position(5, 5)) shouldBe List(
        Position(4,4), Position(4,5),
        Position(5,4)
      )
    }
  }
}
