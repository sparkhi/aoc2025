package com.knowingwhere.aoc2025.utils

case class InclusiveRange(min: Long, max: Long) {
  require(min <= max, s"$min should be <= $max")

  val minLength: Int = min.toString.length
  val maxLength: Int = max.toString.length

  def isInRange(num: Long): Boolean = {
    num >= min && num <= max
  }

  def hasEvenDigits: Boolean = {
    minLength % 2 == 0 ||
    maxLength % 2 == 0 ||
    maxLength >= minLength + 2
  }

  def mergeWith(another: InclusiveRange): InclusiveRange = {
    if hasOverlap(another) then 
      InclusiveRange(Math.min(min, another.min), Math.max(max, another.max))
    else 
      this
  }

  def hasOverlap(another: InclusiveRange): Boolean = {
    Math.max(min, another.min) <= Math.min(max, another.max)
  }

  def getIncludedEvenDigitsRange: Either[String, InclusiveRange] = {
    if !hasEvenDigits then
      Left("Impossible to get even digits range")
    else
      val newMin: Long = if minLength % 2 == 0 then min else Math.pow(10, minLength).toLong
      val newMax: Long = if maxLength % 2 == 0 then max else (Math.pow(10, maxLength - 1) - 1).toLong
      Right(InclusiveRange(newMin, newMax))
  }
}
