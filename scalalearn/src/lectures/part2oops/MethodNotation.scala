package lectures.part2oops

object MethodNotation extends App {


  class Person(val name:String, favMovie:String, val age:Int = 20){

    def likes(movie:String) = movie == this.favMovie
    def +(person:Person) = s"${this.name} hangsout with ${person.name}"
    def +(str:String):Person = new Person(s"${name} ( ${str} )", favMovie)
    def unary_! :String = s"hello !"
    def unary_+ :Person = new Person(name, favMovie, age+1)
    def isAlive :Boolean = true
    def apply():String = s"hello $name likes $favMovie"
    def apply(n:Int) = s"$name watched $favMovie $n times"
    def learns(name:String) = s"${this.name} learns $name"
    def learnsScala = this learns "scala"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // infix notation
  println(mary likes "Inception")
  println((mary + "the rockstar")())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(3))

  val tom = new Person("Tom", "Bahubali")
  println(tom.+(mary))
  println(tom + mary)

  println(1.+(2))
  println(1 + 2)

  // prefix notation
  val x = -1
  val y = 1.unary_- // same as x = -1
  // unary_ works with + - ! ~
  println(y)
  println(!mary)

  // postfix notation - only for methods without parameters
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent to mary.apply() - removes the barrier between object oriented prog and functional prog
}

