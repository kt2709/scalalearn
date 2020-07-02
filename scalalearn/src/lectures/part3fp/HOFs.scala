package lectures.part3fp

object HOFs extends App {

  // Higher order function
  // Function returning another funciton or function taking in function as parameter/
  // Ex: Map, Flatmap, Filter etc.

  val superFunction: Int => (Int => String) = a => b => b.toString
  println(superFunction(4)(5))


  // f, x, n = f(f(f....f(x)))
  def nTimes(f: Int => Int, x: Int , n: Int):Int = {
    if(n <= 0) x
    else nTimes(f, f(x) , n-1)
  }

  def plusone:Int => Int = _ + 1

  println(nTimes(plusone, 1, 5)) // 1+1+1+1+1+1

  // Return function or lambda
  def nTimesBetter(f: Int=>Int, n: Int): Int => Int = {
    if(n <= 0) (x: Int) => x
    else (x:Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusone, 10)
  println(plus10(1))

  // curried function
  val superAdder: Int => Int => Int = x => y => x + y
  val add3 = superAdder(3) // y = 3+y
  println(add3(4))

  // Functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat:(Double => String) = curriedFormatter("%4.2f")
  println(standardFormat(Math.PI))

  val precisionFormat:(Double => String) = curriedFormatter("%4.8f")
  println(precisionFormat(Math.PI))

  val test: Int=>Int = x => x+1
}
