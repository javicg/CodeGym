package algorithms.dynamicprogramming

object RedJohnIsBack extends App {
  val in = new java.util.Scanner(System.in)

  val t = in.nextLine().toInt

  for (i <- 1 to t) {
    val n = in.nextLine().toInt
    println(solve(n))
  }


  private def solve(n: Int): Int = {
    val m = countNumWalls(n)
    countPrimesUpTo(m)
  }

  private def countNumWalls(n: Int): Int = {
    val D = Array.ofDim[Int](n + 1)
    D(0) = 0
    if (n > 0) {
      D(1) = 1
    }
    if (n > 1) {
      D(2) = 1
    }
    if (n > 2) {
      D(3) = 1
    }
    if (n > 3) {
      D(4) = 2
    }
    for (i <- 5 to n) {
      D(i) = D(i - 1) + D(i - 4)
    }
    D(n)
  }

  private def countPrimesUpTo(n: Int): Int = {
    val tagged = Array.ofDim[Boolean](n - 1)
    for (i <- 2 to n) {
      if (!tagged(i - 2)) {
        var curr = i * 2
        while (curr <= n) {
          tagged(curr - 2) = true
          curr += i
        }
      }
    }

    tagged.count(tg => !tg)
  }
}
