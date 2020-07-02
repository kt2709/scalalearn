package lectures.part2oops

object Generics extends App {

  // Generic Type
  class MyList[A]

  val x = new MyList[Int]
  val y = new MyList[String]

  // Generic Methods
  object MyList{
    def func[A]: MyList[A] = ???
  }

  val z = MyList.func[Int]

  // Variance Problem
  // Can list of animals hold list of cats or dogs
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // 1. Yes, Covariance
  class CovarianceList[+A] {
    def add[B >: A](element: B): MyList[B] = ??? // For solving hard question of adding dogs in cat list
  }

  val animal:Animal = new Cat
  val covariantAnimalList:CovarianceList[Animal] = new CovarianceList[Cat]
  //covariantAnimalList.add(new Dog) ??? HARD QUESTION - we return list of animals

  // 2. No, Invariance
  class InvariantList[A] // Like MyList[A]

  val invariantAnimalList:InvariantList[Animal] = new InvariantList[Animal]

  // 3. Contravariance
  class ContravariantList[-A]

  val contravariantList:ContravariantList[Cat] = new ContravariantList[Animal] // doesnt' make sense
  val contravariantListofTrainers:ContravariantList[Cat] = new ContravariantList[Animal] // Looking for cat trainers but can accomodate any animal trainer.


  // Bounded Types
  class Cage[A <: Animal](animal: A) // Restrict to only sub types of Animal ie. cat or dog ...can't add car etc.

  val test = new Cage(new Dog)
}
