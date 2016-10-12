package algorithms.implementation

object DivisibleSumPairsScala extends App {
  val in = new java.util.Scanner(System.in)
  val firstLineChunks = in.nextLine().split(" ")

  val n = firstLineChunks(0).toInt
  val k = firstLineChunks(1).toFloat

  val numbers = in.nextLine().split(" ")
  val allPairs =
    for {
      (numI, i) <- numbers.zipWithIndex
      (numJ, j) <- numbers.drop(i + 1).zipWithIndex
    } yield (numI.toInt, numJ.toInt)

  val divisibleSumPairs = allPairs.count(p => ((p._1 + p._2) / k) % 1 == 0)
  println(divisibleSumPairs)
}
