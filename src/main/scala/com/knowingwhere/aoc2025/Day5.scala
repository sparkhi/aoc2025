package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.InclusiveRange

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
  }

  private def containsInAny(ranges: List[InclusiveRange], item: Long): Boolean = {
    ranges.exists(_.isInRange(item) == true)
  }


  private def getInclusiveRange(rangeStr: String): InclusiveRange = {
    val elements = rangeStr.split("-")
    InclusiveRange(elements.head.strip().toLong, elements.last.strip().toLong)
  }
}
