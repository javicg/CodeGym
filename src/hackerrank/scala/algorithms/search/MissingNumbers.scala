package algorithms.search

import scala.collection.immutable.TreeMap

object MissingNumbers extends App {
  val in = new java.util.Scanner(System.in)

  val n = in.nextLine().toInt
  val a = in.nextLine().split("\\s").map(_.toInt)

  val m = in.nextLine().toInt
  val b = in.nextLine().split("\\s").map(_.toInt)

  var cache = TreeMap.empty[Int, Int]

  // Cache occurrences in B
  for (el <- b) {
    cache += el -> (cache.getOrElse(el, 0) + 1)
  }

  // Update cache with values from A
  for (el <- a) {
    val count = cache(el)
    if (count == 1) {
      cache -= el
    } else {
      cache += el -> (count - 1)
    }
  }

  // List remaining cache keys
  println(cache.keys.mkString(" "))

}
