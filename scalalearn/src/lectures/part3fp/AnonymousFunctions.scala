package lectures.part3fp

import lectures.part3fp.MyListFunctionTypes.listofIntegers

object AnonymousFunctions extends App {

  val test = new Function1[Int, String] {
    override def apply(v1: Int): String = v1.toString
  }

  // Anonymous Function = Lambdas
  val Int2String: Int => String = x => x.toString

  val adder = (a: Int, b: Int) => a + b

  // No params
  val justFunc: () => Int = () => 3

  // Careful
  println(justFunc()) // Makes actual function call
  println(justFunc) // Will print only function

  // Curly braces
  val xyz: String => Int = { x =>
    x.toInt
  }

  // More syntactic sugar
  val niceIncrementer:Int => Int = _ + 1 // x => x+1 can be written as _ + 1
  val niceAdder:(Int, Int) => Int = _ + _ // (a,b) => a+b


  val listofIntegers: MyList[Int] = new Cons(1, new Cons(2, Empty))
  println(listofIntegers.map(_ * 2).toString)

  val superAdder: (Int => Int => Int) = x => y => x+y

  println(superAdder(3)(4))
}
