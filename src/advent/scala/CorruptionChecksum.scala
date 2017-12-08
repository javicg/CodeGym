import scala.io.Source

object CorruptionChecksum_Part1 extends App {
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

object CorruptionChecksum_Part2 extends App {
  var sum = 0
  for (line <- Source.fromFile("src/advent/scala/CorruptionChecksum.txt").getLines) {
    val lineValues = line.split("\\s")
    for (value1 <- lineValues; value2 <- lineValues) {
      if (value1 != value2) {
        val number1 = value1.toInt
        val number2 = value2.toInt
        if (number1 % number2 == 0) {
          sum += number1 / number2
        } else if (number2 % number1 == 0) {
          sum += number2 / number1
        }
      }
    }
  }
  println(sum / 2)
}