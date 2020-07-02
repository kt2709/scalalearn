package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int):Int = {
    if(n == 1) 1
    else n * factorial(n-1)
  }

  def anotherFactorial(n:Int): BigInt = {
    @tailrec
    def factHelper(x:Int, acc:BigInt): BigInt = {
      if( x <= 1) acc
      else factHelper(x-1, x * acc)
    }

    factHelper(n,1)
  }

  //println(anotherFactorial(5000))

  def concatString(str: String, n: Int): String = {
    def concatStrHelper(str: String, n: Int, acc: String):String = {
      if(n == 1) acc
      else concatStrHelper(str, n-1, acc + str)

    }
    concatStrHelper(str, n, str)
  }

  println(concatString("hello", 2))

}
