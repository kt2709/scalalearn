package lectures.part2oops

object Anonymous extends App {

  abstract class Animal {
    def eat:Unit
  }

  // Anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("dfdfd")
  }

  // above is equivalent to
  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = println("dfdfd")
  }
  val funAnimal = new AnonymousClasses$$anon$1


  class Person(name:String){
    def speak= println("hello")
  }

  // Anonymous class inheritance
  val jim = new Person("Jim"){
    override def speak: Unit = println("say jim hello")
  }
  jim.speak
}
