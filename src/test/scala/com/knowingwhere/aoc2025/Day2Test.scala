package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.InclusiveRange
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class Day2Test extends AnyWordSpec {
  "Day 2" should {
    "get correct repeating patterns in range " in {
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(1, 19), 1, List.empty) shouldBe List(11)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(11, 22), 1, List.empty) shouldBe List(11, 22)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(95, 115), 1, List.empty) shouldBe List(99)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(998, 1012), 1, List.empty) shouldBe List(1010)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(1188511880, 1188511890), 1, List.empty) shouldBe List(1188511885)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(222220, 222224), 1, List.empty) shouldBe List(222222)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(1698522, 1698528), 1, List.empty) shouldBe List.empty
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(446443, 446449), 1, List.empty) shouldBe List(446446)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(38593856, 38593862), 1, List.empty) shouldBe List(38593859)
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(565653, 565659), 1, List.empty) shouldBe List.empty
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(824824821, 824824827), 1, List.empty) shouldBe List.empty
      Day2.getListOfRecurringDigitsWithinRange(InclusiveRange(2121212118, 2121212124), 1, List.empty) shouldBe List.empty
    }
  }
}
