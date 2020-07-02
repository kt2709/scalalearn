package lectures.part3fp

object maps extends App {

  val a = List(1,2,3)
  println(a.head)
  println(a.tail)

  println(a.map(_+1))

  println(a.filter(_ % 2 == 0))

  var nos = List(1,2,3,4)
  var chars = List('a','b')

  // Iterating over loops can be written as flatmap / maps
  println(nos.flatMap(n => chars.map(c =>  c + "-" + n)))

  // for-comprehensions
  var result = for {
    n <- nos
    c <- chars

  }yield c + "-" + n

  println(result)

  var result1 = for {
    n <- nos if n % 2 == 0
    c <- chars

  }yield c + "-" + n

  println(result1)

  for {
    n <- nos
  } println(n)


}
