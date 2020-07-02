package lectures.part2oops

object InheritanceAndTraits extends App {

    // Single inheritance
    class Animal{

      val creatureType = "wild"
      protected def eat = println("eat eat")

    }

    class Cat extends Animal{

      def crunch = {
        eat
      }
    }

    class Dog(override val creatureType: String) extends Animal{
      // override val creatureType = "domestic"
      override def eat: Unit = {
        super.eat
        println("dog dog")
      }
    }



    // Access modifiers : no/default/public, private (same class), protected(only subclass)
    val c = new Cat
    c.crunch

    //Constructors

    class Person(name:String, age:Int)
    class Adult(name:String, age:Int, idCard:Int) extends Person(name, age) // note it has pass the parameters correctly

    // overriding
    val d = new Dog("domestic")
    d.eat
    println(d.creatureType)

    //super
    d.eat

    // prevent overriding
    // 1. final on members / class
    // 2. sealed - will allow extension in THIS FILE ONLY and not other files
    sealed class Test

}
