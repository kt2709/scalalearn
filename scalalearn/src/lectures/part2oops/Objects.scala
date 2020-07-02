package lectures.part2oops

object Objects extends App {

  // Scala doesnt have class level functionality like static
  // object is type + its own instance
  // Singleton instance
  // Used for factory
  object Person{
    // Static level functionality
    val N_EYES = 2
    def canFly = false
    def apply(mother:Person, father:Person):Person = new Person("Sriram") // factory method
  }

  class Person(val name:String){
    // Instance Level Functionality
  }
  // COMPANIONS - Same class name and object name in the same scope.

  println(Person.N_EYES)
  println(Person.canFly)

  val sai = new Person("Sai")
  val ram = new Person("Ram")

  val sriram = Person(sai, ram) // same as Person.apply(sai, ram)

  println(sai == ram)  // returns false

  val a = Person
  val b = Person
  println(a == b)  // returns true as it is singleton

  // Scala Applications
  // def main(args: Array[String]): Unit  or object extends App
}
