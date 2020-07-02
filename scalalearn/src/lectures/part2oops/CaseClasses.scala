package lectures.part2oops

object CaseClasses extends App {

  // 1. Special classes - Case
  // 2. Implements toString,hashCode and equals

  case class Person(name:String, age:Int)
  println(Person)

  // 3. Parameters are fields.
  // 4. Sensible toString
  // println(obj) = println(obj.toString)
  val a  = new Person("and",24)
  println(a)
  println(a.age)

  // 5. equals and hashcode implemented OOTB
  val b = new Person("and",24)
  println(a == b)

  // 6. CCs have copy method
  val c = a.copy(age=46)
  println(c)
  println(c == a)

  // 7. CCs have companion objects
  val mary = Person
  mary("Mary", 35) // You don't need to use new for creating objects. Directly use Person.

  // 8. CCs are serializable ( can be passed through network - distributed computing )
  // Akka

  // 9. CCs have extractor patterns - PATTERN MATCHING

  case object Test {
    def func = "dfdfd"
  }
  println(Test.func)

}
