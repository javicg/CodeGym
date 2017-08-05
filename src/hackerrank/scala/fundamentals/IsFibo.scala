package fundamentals

object IsFibo extends App {
  val in = new java.util.Scanner(System.in)

  var fibos = Set(0L, 1L)
  var lastCached = 1L

  val t = in.nextLine().toInt
  for (test <- 1 to t) {
    val n = in.nextLine().toLong

    if (n == 0 || n == 1) {
      println("IsFibo")
    } else if (fibos.contains(n)) {
      println("IsFibo")
    } else {
      var prev = 0L
      var curr = 1L
      while (curr < n) {
        val next = curr + prev
        prev = curr
        curr = next
        if (next > lastCached) {
          fibos += next
          lastCached = next
        }
      }

      if (curr == n) {
        println("IsFibo")
      } else {
        println("IsNotFibo")
      }
    }
  }

}
