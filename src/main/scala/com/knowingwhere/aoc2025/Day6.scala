package com.knowingwhere.aoc2025

import scala.annotation.tailrec
import scala.io.Source

object Day6 {
  def main(args: Array[String]) = {
    val lines = Source.fromResource("day6-input.txt").getLines().toList
    val operatorsLine = lines.last
    val problems = LoadProblems(lines.init, lines.last, 0, List.empty)
    println(problems.map(_.result).sum)
    
    val problems2 = LoadProblems2(lines.init, lines.last, 0, List.empty)
    println(problems2.map(_.result).sum)
  }

  @tailrec
  def LoadProblems2(operandLines: List[String], operatorLine: String, currentIndex: Int, accumulatedProblems: List[Problem]): List[Problem] = {
    val nextNonSpace = operatorLine.indexWhere(!_.isWhitespace, currentIndex + 1)
    if nextNonSpace == -1 then
      val problemValues = transposedList(operandLines.map(_.substring(currentIndex)), 0, List.empty)
      val operator = operatorLine.substring(currentIndex).strip()
      accumulatedProblems :+ Problem(problemValues, operator)
    else {
      val problemValues2 = transposedList(operandLines.map(_.substring(currentIndex, nextNonSpace - 1)), 0, List.empty)
      val operator = operatorLine.substring(currentIndex, nextNonSpace - 1).strip()
      LoadProblems2(operandLines, operatorLine, nextNonSpace, accumulatedProblems :+ Problem(problemValues2, operator))
    }
  }

  def transposedList(original: List[String], index: Int, accumulated: List[Long]): List[Long] = {
    if (index >= original.head.length) then
      accumulated
    else {
      val transposed = original.map(_.substring(index, index + 1)).mkString.strip().toLong
      transposedList(original, index + 1, accumulated :+ transposed)
    }
  }


  @tailrec
  def LoadProblems(operandLines: List[String], operatorLine: String, currentIndex: Int, accumulatedProblems: List[Problem]): List[Problem] = {
    val nextNonSpace =  operatorLine.indexWhere(!_.isWhitespace, currentIndex + 1)
    if nextNonSpace == -1 then
      val problemValues = operandLines.map(_.substring(currentIndex)).map(_.strip().toLong)
      val operator = operatorLine.substring(currentIndex).strip()
      accumulatedProblems :+ Problem(problemValues, operator)
    else {
      val problemValues = operandLines.map(_.substring(currentIndex, nextNonSpace)).map(_.strip().toLong)
      val operator = operatorLine.substring(currentIndex, nextNonSpace).strip()
      LoadProblems(operandLines, operatorLine, nextNonSpace, accumulatedProblems :+ Problem(problemValues, operator))
    }
  }
}

case class Problem(operands: List[Long], operator: String) {
  def result: Long = operator match {
    case "*" => operands.product
    case "+" => operands.sum
    case _ => throw new IllegalArgumentException("Houston, we have a problem")
  }
}
