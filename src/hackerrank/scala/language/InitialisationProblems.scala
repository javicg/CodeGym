package language

object InitialisationProblems extends App {

  trait Base {
    val foo: Int
    val bar: Int = foo + foo
  }

  trait Impl extends Base {
    val foo: Int = 42
  }

  val impl = new Impl {}
  println(impl.bar)

}
