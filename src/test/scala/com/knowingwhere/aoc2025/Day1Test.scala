package com.knowingwhere.aoc2025

import org.scalatest.*
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class Day1Test extends AnyWordSpec with BeforeAndAfterEach {
  private var movements: List[String] = List(
    "L68",
    "L30",
    "R48",
    "L5",
    "R60",
    "L55",
    "L1",
    "L99",
    "R14",
    "L82"
  )

  override def beforeEach(): Unit = {
    super.beforeEach()
  }

  override def afterEach(): Unit = {
    super.afterEach()
  }

  "Day 1 " should {
    "generate the number of times the dial rests to zero as 3" in {
      val count = Day1.getCountForDialReachingZero(movements, 50, 0)
      count shouldBe 3
    }
    "generate the number of times the dial crosses zero as 6" in {
      
    }
  }
}
