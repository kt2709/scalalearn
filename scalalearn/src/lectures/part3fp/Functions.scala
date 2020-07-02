package lectures.part3fp

object Functions extends App {

  val StringtoIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(StringtoIntConverter("4"))

  // Function2[A,B,R] === ((A,B) => R)
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int]{
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(3,4))

  val stringConcat: Function2[String, String, String] = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1.concat(v2)
  }

  println(stringConcat("hello", "world"))

  trait MyPredicate[-T] { // Funciton type T => Boolean
    def test(element: T): Boolean
  }

  val test = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = 34
  }
  println(test(3,5))

  val Int2String: Int => String = new Function1[Int, String] {
    override def apply(v1: Int): String = v1.toString
  }
  println(Int2String(4))

  // Curry Functions
  val superAdder: (Int => Int => Int) = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int)  = new Function1[Int, Int]{
      override def apply(v2: Int) = v1 + v2
    }
  }


  println(superAdder(3)(6))
}
