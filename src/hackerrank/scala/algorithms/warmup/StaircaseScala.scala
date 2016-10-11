package algorithms.warmup


object StaircaseScala extends App {
  val in = new java.util.Scanner(System.in)
  val n = in.nextInt()

  for (i <- (n - 1) to 0 by -1) {
    val padding = Stream.fill(i)(' ').mkString
    val step = Stream.fill(n - i)('#').mkString
    println(padding + step)
  }
}
