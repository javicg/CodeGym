package algorithms.dynamicprogramming

object TheCoinChangeProblem extends App {
  val in = new java.util.Scanner(System.in)

  val change = in.nextLine().split("\\s")(0).toInt
  val coins = in.nextLine().split("\\s").map(_.toInt)

  Dynamic.solve(change, coins)

  object Dynamic {
    def solve(change: Int, coins: Array[Int]): Unit = {
      val D = Array.ofDim[Long](change + 1, coins.length + 1)

      for (q <- 1 to change) {
        for (i <- 1 to coins.length) {
          val c = coins(i-1)
          D(q)(i) = D(q)(i-1) + computeAddition(q, i, c)
        }
      }

      println(D(change)(coins.length))

      def computeAddition(q: Int, i: Int, c: Int): Long = {
        if (q == c)
          1
        else if (c < q)
          D(q - c)(i)
        else
          0
      }
    }
  }

  object RecursiveWithMemo {

    def solve(change: Int, coins: Array[Int]): Unit = {
      val memo = Array.ofDim[Int](250, 50)
      val memoSet = Array.ofDim[Boolean](250, 50)
      println(computeChangeCombinations(change, coins, memo, memoSet))
    }

    private def computeChangeCombinations(qty: Int, coins: Array[Int],
                                          memo: Array[Array[Int]], memoSet: Array[Array[Boolean]]): Int = {
      if (qty == 0 || coins.isEmpty) {
        0
      } else {
        val coin = coins.head
        if (!memoSet(qty)(coin)) {
          memo(qty)(coin) = computeChangeCombinationsWithCoin(qty, coins, coin, memo, memoSet)
          memoSet(qty)(coin) = true
        }
        memo(qty)(coin)
      }
    }

    private def computeChangeCombinationsWithCoin(qty: Int, coins: Array[Int], coin: Int,
                                                  memo: Array[Array[Int]], memoSet: Array[Array[Boolean]]): Int = {
      val combinationsFromTail = computeChangeCombinations(qty, coins.tail, memo, memoSet)
      if (coin == qty) {
        1 + combinationsFromTail
      } else if (coin < qty) {
        computeChangeCombinations(qty - coin, coins, memo, memoSet) + combinationsFromTail
      } else {
        combinationsFromTail
      }
    }
  }

}