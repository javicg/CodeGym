package algorithms.graphs

// TODO Review (wrong solution)
// - Runtime error on some cases (memory issues?)
// - Wrong answer on 1 case
// - Timeout in the majority (pre-computing all combinations is inefficient!)
object JourneyToTheMoon extends App {
  val in = new java.util.Scanner(System.in)

  val firstLine = in.nextLine().split("\\s").map(_.toInt)
  val n = firstLine(0)
  val p = firstLine(1)

  val graph = new Graph(n)

  (1 to p).foreach(_ => {
    val pair = in.nextLine().split("\\s").map(_.toInt)
    graph.group(pair(0), pair(1))
  })

  println(graph.countUnconnectedPairs())

  class Graph(n: Int) {
    private var connected: Map[Int, Set[Int]] = Map.empty
    private var unconnected: Map[Int, Set[Int]] = Map.empty

    for (i <- 0 until n-1) {
      unconnected += i -> (i+1 until n).toSet
    }

    def group(i: Int, j: Int): Unit = {
      if (i > j) {
        group(j, i)
      } else {
        val neighbours = connected.get(i)
        if (neighbours.isEmpty) {
          connected += i -> Set(j)
          unconnected += i -> unconnected(i).filterNot(el => el == j)
        } else {
          neighbours.get.foreach(el => group(el, j))
          connected += i -> (connected(i) + j)
          unconnected += i -> unconnected(i).filterNot(el => el == j)
        }
      }
    }

    def countUnconnectedPairs(): Long = {
      unconnected.values.map(s => s.size.toLong).sum
    }
  }
}
