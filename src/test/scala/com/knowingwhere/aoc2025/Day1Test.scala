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
      val count = Day1.getCountForDialCrossingZero(movements, 50, 0)
      count shouldBe 6
    }
    "get zero crossing count as 0 for simple addition and subtraction cases " in {
      Day1.getZeroCrossingCount(10, 20, 'R') shouldBe 0
      Day1.getZeroCrossingCount(10, 89, 'R') shouldBe 0
      Day1.getZeroCrossingCount(0, 20, 'R') shouldBe 0
      Day1.getZeroCrossingCount(70, 40, 'L') shouldBe 0
      Day1.getZeroCrossingCount(50, 48, 'L') shouldBe 0
      Day1.getZeroCrossingCount(0, 20, 'L') shouldBe 0
    }
    "get zero crossing count as 1 for simple addition and subtraction cases " in {
      Day1.getZeroCrossingCount(90, 20, 'R') shouldBe 1
      Day1.getZeroCrossingCount(60, 40, 'R') shouldBe 1
      Day1.getZeroCrossingCount(20, 30, 'L') shouldBe 1
      Day1.getZeroCrossingCount(15, 15, 'L') shouldBe 1
    }
    "get zero crossing count as 2 when the dial turns more than one full circle" in {
      Day1.getZeroCrossingCount(90, 120, 'R') shouldBe 2
      Day1.getZeroCrossingCount(60, 140, 'R') shouldBe 2
      Day1.getZeroCrossingCount(20, 130, 'L') shouldBe 2
      Day1.getZeroCrossingCount(15, 115, 'L') shouldBe 2
    }
    "get zero crossing count when the dial turns lots of circles than one full circle" in {
      Day1.getZeroCrossingCount(90, 111, 'R') shouldBe 2
      Day1.getZeroCrossingCount(60, 440, 'R') shouldBe 5
      Day1.getZeroCrossingCount(20, 330, 'L') shouldBe 4
      Day1.getZeroCrossingCount(15, 120, 'L') shouldBe 2
    }
    "get zero crossing count when starting at zero and going exact full circle" in {
      Day1.getZeroCrossingCount(0, 100, 'L') shouldBe 1
      Day1.getZeroCrossingCount(0, 100, 'R') shouldBe 1
    }
  }
}
