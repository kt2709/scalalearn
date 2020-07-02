package lectures.part4patterns

import scala.util.{Failure, Success, Try}

object Patterns extends App {

  val aInteger = 34
  val result = aInteger match {
    case 1 => "1"
    case _ => "4"
  }
  println(result)

  // Pattern matching can be applied only on case classes
  // helps to deconstruct case class
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 24)

  val personGreeting = bob match {
    case Person(n, a) => s"Name is $n and Age is $a"
    case _ => "You scuks"
  }

  println(personGreeting)

  // Deconstructing Tuples
  val aTuple = ("a","b")
  val pmatch = aTuple match {
    case (c, d) => s" $c and $d"
    case _ => "addsfsa"
  }
  println(aTuple)

  // Deconstructing Lists
  val aList = List(1,3,4)
  val listDesc = aList match {
    case List(_,_,a) => s"$a"
    case _ => "asdfsadf"
  }
  println(aList)

    // No match - throws match error
  // pm will try all case statements in sequence.

  def someMethod(): String = "dfd"

  val anOption = Option(someMethod())

  val omatch = anOption match {
    case Some(value) => s"$value"
    case None => "None"
  }
  println(omatch)

  def someBadMethod(): String = throw new RuntimeException("ters")
  val aTry = Try(someBadMethod())

  val tm = aTry match {
    case Success(value) => s"$value"
    case Failure(ex) => s"$ex"
  }
  println(tm)


}
