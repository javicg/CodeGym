package algorithms.implementation

object KangarooScala extends App {
  val in = new java.util.Scanner(System.in)

  val x1 = in.nextInt()
  val v1 = in.nextInt()
  val x2 = in.nextInt()
  val v2 = in.nextInt()

  var result = "NO"
  if (v1 > v2) {
    val startingDiff = (x1 - x2).toDouble
    val velocityDiff = (v2 - v1).toDouble
    val numJumps = startingDiff / velocityDiff
    if (numJumps % 1 == 0) {
      result = "YES"
    }
  }

  println(result)
}
