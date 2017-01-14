package language

object Variance {
  trait Drink
  trait SoftDrink extends Drink
  trait Cola extends SoftDrink
  trait TonicWater extends SoftDrink
  trait Juice extends Drink
  trait OrangeJuice extends Juice
  trait AppleJuice extends Juice

  class VendingMachine[+A <: Drink] {

  }

  def install(softDrinkVM: VendingMachine[SoftDrink]): Unit = {}

  ///////////

  trait Person {
    val age: Int
  }
  case class Student(age: Int) extends Person
  case class Worker(age: Int) extends Person

  def isAdult(p: Person): Boolean = p.age > 18


  def main(args: Array[String]): Unit = {
    val colaVM = new VendingMachine[Cola]
    val tonicVM = new VendingMachine[TonicWater]

    install(colaVM)
    install(tonicVM)

    ///////////

    val students = List(Student(20), Student(16))
    val adultStudents = students.filter(isAdult)
    println(adultStudents)

    val workers = List(Worker(45), Worker(17))
    val adultWorkers = workers.filter(isAdult)
    println(adultWorkers)
  }

}
