package structures.sandbox

object AllPairsSumK extends App {
  val array = Array(1, 7, 5, 9, 2, 12, 3)
  val diff = 2

  val map = array.groupBy(x => x)
  var countPairsWithDiff = 0
  array.foreach(el => {
    if (map.contains(el - diff)) {
      countPairsWithDiff += 1
    }
  })

  println(s"Number of pairs with diff $diff is $countPairsWithDiff")
}
