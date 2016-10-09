
object TimeConversionScala extends App {
  val in = new java.util.Scanner(System.in)
  val input = in.nextLine()

  val hh = input.take(2)
  val merid = input.takeRight(2)

  val hh24 = hh match {
    case "12" =>
      if ("PM".equals(merid)) {
        "12"
      } else {
        "00"
      }
    case _ =>
      if ("AM".equals(merid)) {
        hh
      } else {
        (hh.toInt + 12).toString
      }
  }

  print(hh24 + input.substring(2, input.length - 2))
}
