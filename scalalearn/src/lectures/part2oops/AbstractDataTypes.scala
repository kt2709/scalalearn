package lectures.part2oops

object AbstractDataTypes extends App {

  // Abstract Class
  // Can have implemented and non implemented methods / fields
  abstract class Animal(val creatureType:String = "Wild"){
    //val creatureType = "Wild"
    def eat
  }

  class Dog(override val creatureType:String) extends Animal{
    //override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  val dog = new Dog("Canine")
  dog.eat
  println(dog.creatureType)

  trait Carnivore{
    def eat = println("eat meat")
  }

  trait ColdBlooded {

  }

  // Can extend single class but multiple traits
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override def eat: Unit = println("outch outch")
    def eat(animal: Animal) = println(s"I am eating ${animal.creatureType}")
  }

  val croc = new Crocodile
  croc.eat(dog)

  // Traits Vs Abstract classes
  // 1. Traits don't have constructor parameters
  // 2. Multiple traits may be inherited by a single class
  // 3. Traits = Behavior, Abstract class = Thing
}
