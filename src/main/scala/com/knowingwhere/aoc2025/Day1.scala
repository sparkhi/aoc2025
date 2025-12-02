package com.knowingwhere.aoc2025

import scala.annotation.tailrec
import scala.io.Source
import scala.util.chaining.scalaUtilChainingOps

object Day1 extends App :
  private val lines = Source.fromResource("day1-input.txt").getLines().toList
  val start = 50

  private val counter = getCountForDialReachingZero(lines, 50, 0)
  counter.pipe(println)

  private val counter2 = getCountForDialCrossingZero(lines, 50, 0)
  counter2.pipe(println)

  @tailrec
  def getCountForDialReachingZero(movements: List[String], initialVal: Int, countOfZero: Int): Int = {
    movements match {
      case Nil =>
        countOfZero
      case _ =>
        val instruction = movements.head
        val clicks = instruction.substring(1).toInt
        val newPos = instruction.head match {
          case 'L' => initialVal - clicks
          case 'R' => initialVal + clicks
        }

        val resultantPos = newPos % 100
        val (nextPos, nextZeroCount) = resultantPos match {
          case n if n < 0 => (100 + resultantPos, countOfZero)
          case n if n > 0 => (n, countOfZero)
          case _ => (0, countOfZero + 1)
        }
        getCountForDialReachingZero(movements.tail, nextPos, nextZeroCount)
    }
  }

  @tailrec
  def getCountForDialCrossingZero(movements: List[String], initialVal: Int, countOfCrossingZero: Int): Int = {
    movements match {
      case Nil =>
        countOfCrossingZero
      case _ =>
        val instruction = movements.head
        val clicks = instruction.substring(1).toInt
        val zeroCrossingCount = getZeroCrossingCount(initialVal, clicks, instruction.head)

        val newPos = (instruction.head match {
          case 'L' => initialVal - clicks
          case 'R' => initialVal + clicks
        }) % 100

        val normalisedNewPos = if newPos < 0 then 100 + newPos else newPos

        getCountForDialCrossingZero(movements.tail, normalisedNewPos, countOfCrossingZero + zeroCrossingCount)
    }
  }

  def getZeroCrossingCount(initial: Int, clicks: Int, direction: Char): Int = {
    val turns = clicks / 100
    val resultant = clicks % 100
    val incompleteCrossing = direction match {
      case 'L' =>
        if initial == 0 then 0
        else if resultant >= initial then 1 else 0
      case 'R' =>
        if initial == 0 then 0
        else
          if resultant >= (100 - initial) then 1 else 0
    }
    incompleteCrossing + turns
  }
