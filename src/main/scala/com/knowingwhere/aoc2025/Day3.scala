package com.knowingwhere.aoc2025

import scala.io.Source

class Day3:
  def getLargestTwoDigitNumber(stringOfDigits: String): Int = {
    val maxTensPlace = stringOfDigits.substring(0, stringOfDigits.length - 1).max.toString
    val indexInString = stringOfDigits.indexOf(maxTensPlace)

    val maxUnitsPlace = stringOfDigits.substring(indexInString + 1).max.toString
    (maxTensPlace + maxUnitsPlace).toInt
  }


object Day3 extends App :
  private val lines = Source.fromResource("day3-input.txt").getLines().toList
  private val day3 = new Day3()
  private val jolts = lines.map(eachLine => day3.getLargestTwoDigitNumber(eachLine)).sum
  println(jolts)
