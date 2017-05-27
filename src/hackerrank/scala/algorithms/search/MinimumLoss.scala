package algorithms.search

object MinimumLoss extends App {
  val in = new java.util.Scanner(System.in)

  val n = in.nextLine().toInt
  val prices = in.nextLine.split("\\s").map(_.toLong)

  val sortedPrices = prices.sorted(Ordering.Long.reverse)
  var minLoss = Long.MaxValue
  for(i <- 0 until sortedPrices.length - 1) {
    val currPrice = sortedPrices(i)
    val nextPrice = sortedPrices(i+1)
    if (currPrice - nextPrice < minLoss && prices.indexOf(currPrice) < prices.indexOf(nextPrice)) {
      minLoss = currPrice - nextPrice
    }
  }
  println(minLoss)
}
