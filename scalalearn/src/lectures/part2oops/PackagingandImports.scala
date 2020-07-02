package lectures.part2oops

import playground.Test.Test
import playground.Test.{MyTest => abc}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingandImports extends App {

  val a = new Test {
    override def eat: Unit = ???

    //package object
    println(TEST)
  }

  // Aliasing
  val c = new abc

  val d = new Date()

  val e = new SqlDate(2020,5,5)

  // Default imports
  // java.lang - String, Object, Exception
  // scala.predef - println,???
  // scala - Int, Nothing, Function
}
