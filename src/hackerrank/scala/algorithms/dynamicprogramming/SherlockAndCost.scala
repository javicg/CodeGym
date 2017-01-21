package algorithms.dynamicprogramming

object SherlockAndCost extends App {
  val in = new java.util.Scanner(System.in)
  val numTests = in.nextLine().toInt

  for (i <- 1 to numTests) {
    val n = in.nextLine().toInt
    val array = in.nextLine().split("\\s").map(_.toInt)
    println(maxCost(array))
  }

  def maxCost(array: Array[Int]): Int = {
    if (array.isEmpty) {
      0
    } else {
      val memo = Array.ofDim[Int](2, array.length)
      math.max(maxCost(1, array.tail, memo), maxCost(array.head, array.tail, memo))
    }
  }

  // TODO - Too slow! (iterative more efficient)
  def maxCost(fixedHead: Int, rem: Array[Int], memo: Array[Array[Int]]): Int = {
    if (rem.isEmpty) {
      0
    } else {
      if (memo(0)(rem.length) == 0) {
        memo(0)(rem.length) = maxCost(1, rem.tail, memo)
      }
      val maxCostWithMin = memo(0)(rem.length)

      if (memo(1)(rem.length) == 0) {
        memo(1)(rem.length) = maxCost(rem.head, rem.tail, memo)
      }
      val maxCostWithMax = memo(1)(rem.length)

      math.max(
        maxCostWithMin + math.abs(fixedHead - 1),
        maxCostWithMax + math.abs(fixedHead - rem.head)
      )
    }
  }
}
