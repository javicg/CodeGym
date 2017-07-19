package language

object MagnetPattern {
  def doSomething(magnet: Magnet): magnet.Result = magnet()
}

trait Magnet {
  type Result
  def apply(): Result
}

object Magnet {
  implicit def fromListString(list: List[String]): Magnet = new Magnet {
    override type Result = Unit
    override def apply(): Result = {
      println("Doing stuff with a list of strings...")
    }
  }

  implicit def fromListInt(list: List[Int]): Magnet = new Magnet {
    override type Result = Unit
    override def apply(): Result = {
      println("Doing stuff with a list of ints...")
    }
  }
}