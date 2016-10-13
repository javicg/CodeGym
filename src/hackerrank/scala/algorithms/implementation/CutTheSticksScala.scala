package algorithms.implementation

import scala.collection.immutable.TreeMap

object CutTheSticksScala extends App {
  val in = new java.util.Scanner(System.in)
  var countByNumber = TreeMap[Int, Int]()

  val n = in.nextLine().toInt
  val numbers = in.nextLine().split(" ")
    .map(_.toInt)
    .foreach(i => countByNumber += i -> (countByNumber.getOrElse(i, 0) + 1))

  var remainingSticks = n
  countByNumber.valuesIterator.foreach(v => {
    println(remainingSticks)
    remainingSticks -= v
  })
}
