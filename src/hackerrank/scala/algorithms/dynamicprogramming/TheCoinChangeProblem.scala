package algorithms.dynamicprogramming

object TheCoinChangeProblem extends App {
  val in = new java.util.Scanner(System.in)

  val change = in.nextLine().split("\\s")(0).toInt
  val coins = in.nextLine().split("\\s").map(_.toInt)

  val memo = Array.ofDim[Int](250, 50)
  val memoSet = Array.ofDim[Boolean](250, 50)
  println(computeChangeCombinations(change, coins))

  def computeChangeCombinations(qty: Int, coins: Array[Int]): Int = {
    if (qty == 0 || coins.isEmpty) {
      0
    } else {
      val coin = coins.head
      if (!memoSet(qty)(coin)) {
        memo(qty)(coin) = computeChangeCombinationsWithCoin(qty, coins, coin)
        memoSet(qty)(coin) = true
      }
      memo(qty)(coin)
    }
  }

  def computeChangeCombinationsWithCoin(qty: Int, coins: Array[Int], coin: Int): Int = {
    val combinationsFromTail = computeChangeCombinations(qty, coins.tail)
    if (coin == qty) {
      1 + combinationsFromTail
    } else if (coin < qty) {
      computeChangeCombinations(qty - coin, coins) + combinationsFromTail
    } else {
      combinationsFromTail
    }
  }
}