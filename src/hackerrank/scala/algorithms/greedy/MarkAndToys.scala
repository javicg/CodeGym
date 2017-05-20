package algorithms.greedy

object MarkAndToys extends App {
  val in = new java.util.Scanner(System.in)

  val params = in.nextLine().split("\\s").map(_.toInt)
  var k = params(1)

  val toys = in.nextLine().split("\\s").map(_.toInt).sorted
  if (toys.isEmpty) {
    println(0)
  } else {
    var n = 0
    var i = 0
    while (k > toys(i)) {
      k -= toys(i)
      n += 1
      i += 1
    }
    println(n)
  }
}
