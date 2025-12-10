package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.InclusiveRange

import scala.annotation.tailrec
import scala.io.Source

object Day5 {
  def main (args: Array[String]): Unit = {
    val inputLines = Source.fromResource("day5-input.txt").getLines().toList
    val rangeLines = inputLines.filter(_.contains("-"))
    val idLines = inputLines.filter(line => line.nonEmpty && !line.contains("-"))

    val ingredients = idLines.map(_.toLong)
    val ranges = rangeLines.map(getInclusiveRange)
    val totalFresh = ingredients.count(containsInAny(ranges, _) == true)
    println(totalFresh)

    val sortedRanges = ranges.sortBy(_.min)
    val reducedRanges = reduceRanges(sortedRanges, List.empty)
    val total = reducedRanges.map(eachRange => eachRange.max - eachRange.min + 1).sum
    println(total)

  }

  /**
   * Combines the ranges from the beginning in such a way that overlapping ranges are joined to form new range. 
   * NOTE: ONLY WORKS WHEN THE RANGES ARE SORTED 
   * @param remainingRanges List of ranges to reduce
   * @param accumulatedRanges List to collect discrete ranges
   * @return List of discrete ranges
   */
  @tailrec
  final def reduceRanges(remainingRanges: List[InclusiveRange], accumulatedRanges: List[InclusiveRange]): List[InclusiveRange] = {
    remainingRanges match {
      case Nil => accumulatedRanges
      case _ =>
        val first = remainingRanges.head
        val remainingTail = remainingRanges.tail
        remainingTail match {
          case Nil => reduceRanges(remainingTail, accumulatedRanges :+ first)
          case _ =>
            val second = remainingTail.head
            if first.hasOverlap(second) then
              val mergedRange = first.mergeWith(second)
              reduceRanges(mergedRange :: remainingTail.tail, accumulatedRanges)
            else
              reduceRanges(remainingTail, accumulatedRanges :+ first)
        }
    }
  }

  private def containsInAny(ranges: List[InclusiveRange], item: Long): Boolean = {
    ranges.exists(_.isInRange(item) == true)
  }


  private def getInclusiveRange(rangeStr: String): InclusiveRange = {
    val elements = rangeStr.split("-")
    InclusiveRange(elements.head.strip().toLong, elements.last.strip().toLong)
  }
}
