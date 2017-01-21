package language

import language.Accessors.MyClass

object Accessors {

  class MyClass(val param1: Int, val param2: Int) {
    private val message = "This is an important message"
    println(MyClass.staticStuff)
  }

  object MyClass {
    private val staticStuff = "Static Stuff"
  }

}

object Main {
  val mc = new MyClass(1, 2)
  mc.param1
  mc.param2
}
