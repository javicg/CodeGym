import scala.io.Source

object CorruptionChecksum extends App {
  var sum = 0
  for (line <- Source.fromFile("src/advent/scala/CorruptionChecksum.txt").getLines) {
    var min, max = -1
    for (value <- line.split("\\s")) {
      val number = value.toInt
      if (min == -1 || min > number) {
        min = number
      }
      if (max == -1 || max < number) {
        max = number
      }
    }
    sum += max - min
  }
  println(sum)
}
