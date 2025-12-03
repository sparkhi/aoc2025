package com.knowingwhere.aoc2025

import scala.annotation.tailrec
import scala.io.Source

class Day3:

  @tailrec
  final def getLargestNDigitNumber(stringOfDigits: String, numberOfDigits: Int, accumulatedNumberString: String) : Long = 
    if (accumulatedNumberString.length == numberOfDigits)
      accumulatedNumberString.toLong
    else {
      val maxDigit = stringOfDigits.substring(0, stringOfDigits.length - (numberOfDigits - accumulatedNumberString.length - 1)).max.toString
      val maxDigitIndex = stringOfDigits.indexOf(maxDigit)
  
      val remainingString = stringOfDigits.substring(maxDigitIndex + 1)
      getLargestNDigitNumber(remainingString, numberOfDigits, accumulatedNumberString + maxDigit)
    }


object Day3 extends App :
  private val lines = Source.fromResource("day3-input.txt").getLines().toList
  private val day3 = new Day3()
  private val jolts = lines.map(eachLine => day3.getLargestNDigitNumber(eachLine, 2, "")).sum
  println(jolts)

  private val jolts2 = lines.map(eachLine => day3.getLargestNDigitNumber(eachLine, 12, "")).sum
  println(jolts2)
