package algorithms.search

object IceCreamParlor extends App {
  val in = new java.util.Scanner(System.in)

  val t = in.nextLine().toInt
  for (test <- 1 to t) {
    solveTrip()
  }

  private def solveTrip() = {
    val m = in.nextLine().toInt
    val n = in.nextLine().toInt
    val flavours = in.nextLine().split("\\s").map(_.toInt)

    var hashSums = Map.empty[Int, (Int, Int)]
    for (i <- flavours.indices; j <- i until flavours.length) {
      if (i != j) {
        val sum = flavours(i) + flavours(j)
        if (!hashSums.contains(sum)) {
          hashSums += sum -> (math.min(i, j) + 1, math.max(i, j) + 1)
        }
      }
    }

    val (f1, f2) = hashSums(m)
    println(s"$f1 $f2")
  }
}
