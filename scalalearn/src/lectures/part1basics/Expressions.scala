package lectures.part1basics

object Expressions extends App {

  val x = if(true) 4 else 0
  println(x)

  val y = {
    val a = 3
    val b = a + 1

    if(b > a) "hello" else "goodbye"
  }

  val z = println(y)
  println(z)

  val a = { 2 < 3 }
  val b = {
    if(a) 33 else 99
    45
  }
  println(a)
  println(b)
}
