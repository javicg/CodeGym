
object PlusMinusScala extends App {
  val in = new java.util.Scanner(System.in)

  val n = in.nextLine().toInt
  val numbers = in.nextLine().split(" ").map(_.toInt)

  val posPartition = numbers.partition(i => i > 0)
  val pos = posPartition._1.length.toFloat
  val negPartition = posPartition._2.partition(i => i < 0)
  val neg = negPartition._1.length.toFloat
  val zero = negPartition._2.length.toFloat

  println(pos / n)
  println(neg / n)
  println(zero / n)
}
