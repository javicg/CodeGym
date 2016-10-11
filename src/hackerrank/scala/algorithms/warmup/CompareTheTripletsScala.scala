package algorithms.warmup

object CompareTheTripletsScala extends App {
  val sc = new java.util.Scanner(System.in)
  val ratingAlice = sc.nextLine().split(" ").map(_.toInt)
  val ratingBob = sc.nextLine().split(" ").map(_.toInt)
  val combinedRating = ratingAlice.zip(ratingBob)
  val scoreAlice = combinedRating.count(p => p._1 > p._2)
  val scoreBob = combinedRating.count(p => p._2 > p._1)
  println(scoreAlice + " " + scoreBob)
}
