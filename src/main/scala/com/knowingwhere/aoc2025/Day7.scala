package com.knowingwhere.aoc2025

import scala.io.Source

object Day7 {
  def main(args: Array[String]) = {
    val manifoldLines = Source.fromResource("day7-input.txt").getLines().toList
    val start = manifoldLines.head
    val startBeamPositions = start.replace('S', '|')
    val splitCount = getSplittingCount(manifoldLines.tail, startBeamPositions, 0)
    println(splitCount)
  }
  
  def getSplittingCount(remainingLines: List[String], currentBeamsPosition: String, splitCount: Int): Int = {
    remainingLines match {
      case Nil => splitCount
      case _ => 
        val nextLine = remainingLines.head
        if (!nextLine.contains("^")) then { 
          println(currentBeamsPosition)
          getSplittingCount(remainingLines.tail, currentBeamsPosition, splitCount)
        } else 
          val newState = getNewBeamsPosition(remainingLines.head, currentBeamsPosition, 0, ("", 0))
          println(newState._1)
          getSplittingCount(remainingLines.tail, newState._1, splitCount + newState._2)
    }
  }
  
  def getNewBeamsPosition(manifoldLine: String, currentBeams: String, currIndex: Int, accumulation: (String, Int)): (String, Int) = {
    if currIndex >= manifoldLine.length then
      accumulation
    else {
      val currentChar = manifoldLine.charAt(currIndex)
      val previousChar = if currIndex <= 0 then "" else manifoldLine.charAt(currIndex - 1)
      val nextChar = if currIndex >= manifoldLine.length - 1 then "" else manifoldLine.charAt(currIndex + 1)
      
      val newCurrentChar = { 
        if nextChar == '^' && currentBeams.charAt(currIndex + 1) == '|' then '|'
        else if previousChar == '^' && currentBeams.charAt(currIndex - 1) == '|' then '|'
        else if currentChar == '^' then '.'
        else currentBeams.charAt(currIndex)
      }
      val newString = accumulation._1 + newCurrentChar
      val newSplitCount = if currentChar == '^' && currentBeams.charAt(currIndex) == '|' then accumulation._2 + 1 else accumulation._2 
      getNewBeamsPosition(manifoldLine, currentBeams, currIndex + 1, (newString, newSplitCount))
    }
  }
}
