package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.InclusiveRange
import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

class Day5Test extends AnyWordSpec with BeforeAndAfterEach {
  "Day 5" should {
    "Reduce ranges when initial ranges overlap to produce discrete non-overlapping ranges " in {
      val ranges = List(InclusiveRange(20, 30), InclusiveRange(25, 45), InclusiveRange(50, 70))
      val reduced = Day5.reduceRanges(ranges, List.empty)
      reduced.size shouldBe 2
      reduced.head shouldBe InclusiveRange(20, 45)
      reduced.last shouldBe InclusiveRange(50,70)
    }
    "Reduce ranges when final ranges overlap to produce discrete non-overlapping ranges " in {
      val ranges = List(InclusiveRange(20, 30), InclusiveRange(32, 45), InclusiveRange(44, 70))
      val reduced = Day5.reduceRanges(ranges, List.empty)
      reduced.size shouldBe 2
      reduced.head shouldBe InclusiveRange(20, 30)
      reduced.last shouldBe InclusiveRange(32,70)
    }
    "Reduce ranges when no ranges overlap to produce discrete non-overlapping ranges " in {
      val ranges = List(InclusiveRange(20, 30), InclusiveRange(32, 45), InclusiveRange(48, 70))
      val reduced = Day5.reduceRanges(ranges, List.empty)
      reduced.size shouldBe 3
      reduced.head shouldBe InclusiveRange(20, 30)
      reduced.tail.head shouldBe InclusiveRange(32, 45)
      reduced.last shouldBe InclusiveRange(48,70)
    }
  }
}
