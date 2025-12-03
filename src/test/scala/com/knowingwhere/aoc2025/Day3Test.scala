package com.knowingwhere.aoc2025

import org.scalatest.*
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class Day3Test extends AnyWordSpec with BeforeAndAfterEach {

  "Day 3" should {
    "return the largest number using recursion" in {
      new Day3().getLargestNDigitNumber("987654321111111", 2, "") shouldBe 98
      new Day3().getLargestNDigitNumber("811111111111119", 2, "") shouldBe 89
      new Day3().getLargestNDigitNumber("234234234234278", 2, "") shouldBe 78
      new Day3().getLargestNDigitNumber("818181911112111", 2, "") shouldBe 92
    }
    "return the largest 12 digit number using recursion" in {
      new Day3().getLargestNDigitNumber("987654321111111", 12, "") shouldBe 987654321111L
      new Day3().getLargestNDigitNumber("811111111111119", 12, "") shouldBe 811111111119L
      new Day3().getLargestNDigitNumber("234234234234278", 12, "") shouldBe 434234234278L
      new Day3().getLargestNDigitNumber("818181911112111", 12, "") shouldBe 888911112111L
    }
  }
}