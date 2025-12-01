package com.knowingwhere.aoc2025

import scala.annotation.tailrec
import scala.io.Source
import scala.util.chaining.scalaUtilChainingOps

object Day1 extends App :
  val lines = Source.fromResource("day1-input.txt").getLines().toList
  val start = 50

  val counter = getCountForDialReachingZero(lines, 50, 0)
  counter.pipe(println)

  @tailrec
  def getCountForDialReachingZero(movements: List[String], initialVal: Int, countOfZero: Int): Int = {
    movements match {
      case Nil =>
        countOfZero
      case _ =>
        val instruction = movements.head
        val direction = instruction.substring(0,1)
        val clicks = instruction.substring(1).toInt
        val newPos = (direction match {
          case "L" =>
            initialVal - clicks
          case "R" =>
            initialVal + clicks
        }) % 100
        if (newPos < 0) {
          getCountForDialReachingZero(movements.tail, 100 + newPos, countOfZero)
        } else if (newPos > 0) {
          getCountForDialReachingZero(movements.tail, newPos, countOfZero)
        } else {
          getCountForDialReachingZero(movements.tail, 0, countOfZero + 1)
        }
    }

    @tailrec
    def getCountForDialCrossingZero(movements: List[String], initialVal: Int, countOfCrossingZero: Int): Int = {
      movements match {
        case Nil =>
          countOfCrossingZero
        case _ =>
          val instruction = movements.head
          val direction = instruction.substring(0, 1)
          val clicks = instruction.substring(1).toInt
          val newPos = direction match {
            case "L" =>
              initialVal - clicks
            case "R" =>
              initialVal + clicks
          }
          
          val numberOfFullTurns = newPos / 100
          val resultantPos = newPos % 100
          
          // Dial will cross zero number of times as below:
          // If positive to negative => 1 + numberOfFullTurns
          // If negative to positive => 1 + numberOfFullTurns
          // If 0 to anywhere => numberOfFullTurns
          
          if (newPos < 0) {
            getCountForDialReachingZero(movements.tail, 100 + newPos, countOfZero)
          } else if (newPos > 0) {
            getCountForDialReachingZero(movements.tail, newPos, countOfZero)
          } else {
            getCountForDialReachingZero(movements.tail, 0, countOfZero + 1)
          }
      }
    }