
object CircularArrayRotationScala extends App {
  val in = new java.util.Scanner(System.in)
  val firstLine = in.nextLine().split(" ")

  val n = firstLine(0).toInt
  val k = firstLine(1).toInt
  val q = firstLine(2).toInt

  val array = in.nextLine().split(" ").map(_.toInt)
  (0 until q)
    .map(_ => in.nextInt())
    .map(m => array(modIndex(n, k, m)))
    .foreach(println)

  def modIndex(n: Int, k: Int, m: Int): Int = {
    var res = (n - 1).toLong
    res = res * k
    res = res + m
    (res % n).toInt
  }
}
