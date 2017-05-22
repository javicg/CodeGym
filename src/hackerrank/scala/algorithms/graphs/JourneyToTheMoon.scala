package algorithms.graphs

// TODO Review (wrong solution)
// - Wrong answer on many cases. Review algorithm!
object JourneyToTheMoon extends App {
  val in = new java.util.Scanner(System.in)

  val firstLine = in.nextLine().split("\\s").map(_.toInt)
  val n = firstLine(0)
  val p = firstLine(1)

  val graph = new Graph(n)

  (1 to p).foreach(_ => {
    val pair = in.nextLine().split("\\s").map(_.toInt)
    graph.connect(pair(0), pair(1))
  })

  println(graph.countUnconnectedPairs())

  class Graph(n: Int) {
    private var adj: Map[Int, Set[Int]] = Map.empty
    (0 until n).foreach(el => adj += el -> Set.empty)

    def connect(i: Int, j: Int): Unit = {
      pair(i, j)
      adj(i).foreach(a => pair(j, a))
      adj(j).foreach(a => pair(i, a))
    }

    private def pair(i: Int, j: Int): Unit = {
      addAdj(i, j)
      addAdj(j, i)
    }

    private def addAdj(i: Int, j: Int): Unit = {
      if (i != j) {
        val adjs = adj.get(i)
        if (adjs.isEmpty) {
          adj += i -> Set(j)
        } else {
          adj += i -> (adjs.get + j)
        }
      }
    }

    def countUnconnectedPairs(): Long = {
      var sum: Long = 0
      for (k <- adj.keys) {
        sum += (n - 1) - adj(k).size
      }
      sum / 2
    }
  }
}
