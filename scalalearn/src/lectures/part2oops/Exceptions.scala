package lectures.part2oops

import java.nio.BufferOverflowException

object Exceptions extends App {

  //val x:String = null
  //println(x.length) // crashes the jvm with npe

  // 1. Throwing exception
  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes.
  // Throwing returns Nothing.
  //val xyz = throw new RuntimeException
  //println(xyz)

  // 2. Catching exception
  // try catch is an expression. The value returned is what is returned in try block and catch block.
  // Ex: if try returns int and catch returns unit...then it is of type AnyVal.
  val fail = try{
    throw new RuntimeException
  }catch {
    case e: RuntimeException => println("Caught run time exception")
  }finally {
    //Code that runs always
    println("hello")
  }

  // 3. Custom Exception
  class MyException extends Exception
  val myException = new MyException
  //throw myException


  // OOM
  //val array = Array.ofDim(Int.MaxValue)

  // Stackoverflow
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException

  val x = Int.MaxValue
  val y = 1
  val result = x + y
  if(x > 0 && y > 0 && result < 0)
    throw new OverflowException


  if(x < 0 && y < 0 && result > 0)
    throw new UnderflowException
}
