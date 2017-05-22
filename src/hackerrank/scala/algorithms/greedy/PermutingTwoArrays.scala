package algorithms.greedy

object PermutingTwoArrays extends App {
  val in = new java.util.Scanner(System.in)

  val n = in.nextLine().toInt
  (1 to n).foreach(_ => {
    val lineArgs = in.nextLine().split("\\s").map(_.toInt)
    val cap = lineArgs(1)

    val a = in.nextLine().split("\\s").map(_.toInt).sorted
    val b = in.nextLine().split("\\s").map(_.toInt).sorted(Ordering.Int.reverse)

    if (a.indices.forall(i => a(i) + b(i) >= cap)) {
      println("YES")
    } else {
      println("NO")
    }
  })
}
