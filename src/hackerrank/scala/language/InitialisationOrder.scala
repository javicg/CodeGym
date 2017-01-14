package language

object InitialisationOrder {

  trait A {
    println("A gets initialised")
  }

  trait B {
    println("B gets initialised")
  }

  trait C extends B {
    println("C gets initialised")
  }

  trait D extends A with B {
    println("D gets initialised")
  }

  trait E extends C with D {
    println("E gets initialised")
  }

  def main(args: Array[String]): Unit = {
    println("START")
    val e = new E{
      println("Instance initialisation")
    }
    println("END")
  }

}
