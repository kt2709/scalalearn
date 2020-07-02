package lectures.part1basics

object Functions extends App {

    def aFunction(a: String, b:Int) = a + b

    println(aFunction("helo", 4))

    def greetingFunction(name: String, age: Int): Unit = {
      println("Hi! my name is "+ name + " and i am "+ age + " years old")
    }

    greetingFunction("arun", 35)

    def factorial(n: Int):Int = {
      if(n == 1) 1
      else n * factorial(n-1)
    }

    println(factorial(4))

    def fibonacci(n: Int): Int = {
      if(n <= 2) 1
      else fibonacci(n-1) + fibonacci(n-2)
    }

    println(fibonacci(10))

    def isPrime(n: Int):Boolean = {
      def isPrimeUntil(x:Int):Boolean = {
          if(x <= 1) true
          else n % x != 0 && isPrimeUntil(x-1)
      }
      isPrimeUntil(n / 2)
    }

    println(isPrime(53))
}
