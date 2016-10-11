package algorithms.warmup

import java.util.Scanner

object DiagonalDifferenceScala extends App {
  val in = new Scanner(System.in)
  val n = in.nextLine().toInt

  var acc1, acc2 = 0
  for (i <- 0 until n) {
    val row = in.nextLine().split(" ").map(_.toInt)
    acc1 += row(i)
    acc2 += row(n - i - 1)
  }

  print(math.abs(acc1 - acc2))
}
