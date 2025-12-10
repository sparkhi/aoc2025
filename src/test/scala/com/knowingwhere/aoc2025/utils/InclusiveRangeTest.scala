package com.knowingwhere.aoc2025.utils

import com.knowingwhere.aoc2025.utils.InclusiveRange
import org.scalatest.matchers.should.Matchers.shouldBe
import org.scalatest.wordspec.AnyWordSpec

import scala.language.postfixOps

class InclusiveRangeTest extends AnyWordSpec {
  "InclusiveRange" should {
    "throw exception is min value is greater than max value" in {
      val ex = intercept[IllegalArgumentException] {
        InclusiveRange(1010, 999)
      }
      ex.getMessage shouldBe "requirement failed: 1010 should be <= 999"
    }
    "report as even number of digits if there are even number of digits in the range" in {
      InclusiveRange(99, 100).hasEvenDigits shouldBe true
      InclusiveRange(105, 125).hasEvenDigits shouldBe false
      InclusiveRange(999, 99999).hasEvenDigits shouldBe true
    }
    "get inclusive even digit range should give a new range with just even digit numbers" in {
      InclusiveRange(99, 100).getIncludedEvenDigitsRange shouldBe Right(InclusiveRange(99,99))
      InclusiveRange(999, 1200).getIncludedEvenDigitsRange shouldBe Right(InclusiveRange(1000,1200))
      InclusiveRange(345, 56784).getIncludedEvenDigitsRange shouldBe Right(InclusiveRange(1000,9999))
      InclusiveRange(3456, 5678).getIncludedEvenDigitsRange shouldBe Right(InclusiveRange(3456,5678))
      InclusiveRange(125, 350).getIncludedEvenDigitsRange shouldBe Left("Impossible to get even digits range")
    }
    "report whether the two ranges have any overlap between them" in {
      InclusiveRange(10, 30).hasOverlap(InclusiveRange(2, 9)) shouldBe false
      InclusiveRange(10, 30).hasOverlap(InclusiveRange(31, 45)) shouldBe false
      InclusiveRange(10, 30).hasOverlap(InclusiveRange(20, 40)) shouldBe true
      InclusiveRange(10, 30).hasOverlap(InclusiveRange(30, 40)) shouldBe true
      InclusiveRange(10, 30).hasOverlap(InclusiveRange(5, 15)) shouldBe true
      InclusiveRange(10, 30).hasOverlap(InclusiveRange(5, 10)) shouldBe true
      InclusiveRange(10, 30).hasOverlap(InclusiveRange(11, 18)) shouldBe true
    }
    "generate merged range when ranges overlap, otherwise return the same range " in {
      InclusiveRange(10, 30).mergeWith(InclusiveRange(2, 9)) shouldBe InclusiveRange(10, 30)
      InclusiveRange(10, 30).mergeWith(InclusiveRange(31, 45)) shouldBe InclusiveRange(10, 30)
      InclusiveRange(10, 30).mergeWith(InclusiveRange(20, 40)) shouldBe InclusiveRange(10, 40)
      InclusiveRange(10, 30).mergeWith(InclusiveRange(30, 40)) shouldBe InclusiveRange(10, 40)
      InclusiveRange(10, 30).mergeWith(InclusiveRange(5, 15)) shouldBe InclusiveRange(5, 30)
      InclusiveRange(10, 30).mergeWith(InclusiveRange(5, 10)) shouldBe InclusiveRange(5, 30)
      InclusiveRange(10, 30).mergeWith(InclusiveRange(11, 18)) shouldBe InclusiveRange(10, 30)
    }
  }
}
