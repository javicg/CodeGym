package algorithms.graphs

object JourneyToTheMoon extends App {
  val in = new java.util.Scanner(System.in)

  val firstLine = in.nextLine().split("\\s").map(_.toInt)
  val n = firstLine(0)
  val p = firstLine(1)

  val graph = new Cluster(n)

  (1 to p).foreach(_ => {
    val pair = in.nextLine().split("\\s").map(_.toInt)
    graph.connect(pair(0), pair(1))
  })

  println(graph.countMixedPairs())

  class Cluster(n: Int) {
    private val countries: Array[Int] = (0 until n).toArray

    def connect(i: Int, j: Int): Unit = {
      if (i > j) {
        connect(j, i)
      } else if (i < j) {
        val countryI = countries(i)
        val countryJ = countries(j)
        countries.indices
          .filter(index => countries(index) == countryJ)
          .foreach(index => countries(index) = countryI)
      }
    }

    def countMixedPairs(): Long = {
      var sum: Long = 0
      val groups = groupCountries()
      for (i <- groups.indices) {
        for (j <- i+1 until groups.length) {
          sum += groups(i) * groups(j)
        }
      }
      sum
    }

    private def groupCountries(): Array[Int] = {
      countries.groupBy(x => x).mapValues(_.length).values.toArray
    }
  }
}
