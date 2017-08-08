package algorithms.implementation

object ACMICPCTeam extends App {
  val in = new java.util.Scanner(System.in)

  val firstLine = in.nextLine().split("\\s").map(_.toInt)
  val n = firstLine(0)
  val m = firstLine(1)

  val knowledge = Array.ofDim[Int](n, m)
  for (i <- 0 until n) {
    val topic = in.nextLine().map(c => if (c == '1') 1 else 0).toArray
    knowledge(i) = topic
  }

  var maxTopics = 0
  var cache = Map.empty[Int, Int]
  for(i <- 0 until n) {
    for (j <- (i + 1) until n) {
      val total = sum(knowledge(i), knowledge(j))
      val numPairs = cache.getOrElse(total, 0)
      cache += total -> (numPairs + 1)
      if (total > maxTopics) {
        maxTopics = total
      }
    }
  }

  println(maxTopics)
  println(cache(maxTopics))

  private def sum(a: Array[Int], b: Array[Int]): Int = {
    a.zip(b).map(p => p._1 | p._2).sum
  }
}
