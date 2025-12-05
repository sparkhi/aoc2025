package com.knowingwhere.aoc2025

import com.knowingwhere.aoc2025.utils.InclusiveRange

import scala.annotation.tailrec
import scala.io.Source


object Day2:
  def main(args: Array[String]) : Unit = {
    val inputRanges = Source.fromResource("day2-input.txt").getLines().toList.head
    val rawRanges = inputRanges.split(",").toList.map(eachString => getRangeFromString(eachString))
    val ranges = rawRanges.map(_.getIncludedEvenDigitsRange).collect { case Right(value) => value }
    val invalidIdsList = ranges.map(eachRange => getListOfRecurringDigitsWithinRange(eachRange, eachRange.min.toString.substring(0, eachRange.minLength / 2).toLong, List.empty))

    val invalidIDSum = invalidIdsList.flatten.sum
    println(invalidIDSum)
  }

  def getRangeFromString(rangeStr: String): InclusiveRange = {
    val values = rangeStr.split("-")
    InclusiveRange(values.head.toLong, values.last.toLong)
  }

  def getInvalidIDs(range: InclusiveRange): List[Long] = {
    val newRange = range.getIncludedEvenDigitsRange.getOrElse(throw new IllegalArgumentException())
    val firstHalf = newRange.min.toString.substring(0, newRange.minLength / 2).toLong
    getListOfRecurringDigitsWithinRange(newRange, firstHalf, List.empty)
  }

  @tailrec
  final def getListOfRecurringDigitsWithinRange(range: InclusiveRange, currentHalf: Long, accumulatedList: List[Long]): List[Long] = {
    val newRepeatNum = (currentHalf.toString + currentHalf.toString).toLong
    if newRepeatNum > range.max then
      accumulatedList
    else if range.isInRange(newRepeatNum) then
      getListOfRecurringDigitsWithinRange(range, currentHalf + 1, accumulatedList :+ newRepeatNum)
    else
      getListOfRecurringDigitsWithinRange(range, currentHalf + 1, accumulatedList)
  }
