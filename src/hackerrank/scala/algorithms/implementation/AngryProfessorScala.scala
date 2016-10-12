package algorithms.implementation

object AngryProfessorScala extends App {
  val in = new java.util.Scanner(System.in)

  def analyseTestCase(): Unit = {
    val params = in.nextLine().split(" ").map(_.toInt)
    val k = params(1)

    val arrivals = in.nextLine().split(" ").map(_.toInt)
    val onTime = arrivals.count(_ <= 0)
    println(if (onTime < k) "YES" else "NO")
  }

  private val numTests = in.nextLine().toInt
  (0 until numTests)
    .foreach(_ => analyseTestCase())
}
