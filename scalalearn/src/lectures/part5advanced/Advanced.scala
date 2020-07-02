package lectures.part5advanced

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {

  /*
  Lazy Evaluation
  Nothing gets executed till actually called for
   */
  lazy val test = 34
  lazy val x = {
    println("test")
    5
  } // If not for lazy, println will be executed

  // Used in infinite collections
  val eagerVal = x + 1 // evaluating lazy vals

  /*
  Evaluate something on another thread
  Async programming
   */

  // Need to import scala.concurrent.ExecutionContext.Implicits.global
  // global is like thread pool on which the threads are scheduled to run
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("Done")
    34
  }

  Thread.sleep(1001)
  println(aFuture)
  // Future is a "collection" which contains a value when it is evaluated.
  // Future is composable using map, filter and flatmap

  /* Implicits
  - Compiler smartly finds implicit variables / classes
   */

  implicit val a = 2
  def someFun(implicit x: Int) = x + 1

  println(someFun) // Finds argument automatically using implicit keyword

  // Conversions
  implicit class Test(n: Int){
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // Compiler looks for implicit class... 23 is written as new Test().isEven()


}
