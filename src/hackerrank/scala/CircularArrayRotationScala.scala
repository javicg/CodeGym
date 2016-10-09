
object CircularArrayRotationScala extends App {
  wrongAnswer()

  def timesOut(): Unit = {
    val in = new java.util.Scanner(System.in)
    val firstLine = in.nextLine().split(" ")

    val n = firstLine(0).toInt
    val k = firstLine(1).toInt
    val q = firstLine(2).toInt

    var array = in.nextLine().split(" ").map(_.toInt)

    (0 until k)
      .foreach(_ => array = array.reverse.head +: array.take(n - 1))

    (0 until q)
      .map(_ => in.nextInt())
      .map(i => array(i))
      .foreach(println)
  }

  def wrongAnswer(): Unit = {
    val in = new java.util.Scanner(System.in)
    val firstLine = in.nextLine().split(" ")

    val n = firstLine(0).toInt
    val k = firstLine(1).toInt
    val q = firstLine(2).toInt

    val array = in.nextLine().split(" ").map(_.toInt)
    (0 until q)
      .map(_ => in.nextInt())
      .map(m => array(((n + n - 1) * k + m) % n))
      .foreach(println)
  }
}
