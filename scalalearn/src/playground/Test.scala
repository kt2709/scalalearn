package playground

object Test extends App {

  trait Test{
    def eat
  }

  abstract class Xyz{
    def abc
  }

  class MyTest extends Xyz with Test{
    override def abc: Unit = println("test")

    override def eat: Unit = println("adad")
  }

  val a = new Test {
    override def eat: Unit = ???
  }
  println(a.eat)


}
