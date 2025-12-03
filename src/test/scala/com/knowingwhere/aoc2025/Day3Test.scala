package com.knowingwhere.aoc2025

import org.scalatest.*
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class Day3Test extends AnyWordSpec with BeforeAndAfterEach {
  override def beforeEach(): Unit = {
    super.beforeEach()
  }

  override def afterEach(): Unit = {
    super.afterEach()
  }

  "Day 3" should {
    "return the largest number from a given string of numbers" in {
      new Day3().getLargestTwoDigitNumber("987654321111111") shouldBe 98
      new Day3().getLargestTwoDigitNumber("811111111111119") shouldBe 89
      new Day3().getLargestTwoDigitNumber("234234234234278") shouldBe 78
      new Day3().getLargestTwoDigitNumber("818181911112111") shouldBe 92
    }
  }
}