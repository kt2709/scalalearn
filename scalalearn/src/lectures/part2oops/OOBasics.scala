package lectures.part2oops

object OOBasics extends App {
  val person = new Person("John")
  println(person.x)

  person.greet()
  person.greet("Arun")
}

// Constructor. name and age are parameters.
// They can't be direcly accesssed using person.age
// In order to access, they should have val or var. Ex: val age:Int = 20
class Person(name:String, age:Int = 20){

  // Body can have fields, methods and expressions

  val x = 20

  println("test")

  // Method Overloading
  def greet():Unit = println(s"Hello $name") // equivalent to Hello ${this.name}

  def greet(name:String):Unit = println(s"Hello $name from ... ${this.name}")

}