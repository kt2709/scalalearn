package lectures.part3fp

object Sequences extends App{

  // Sequence
  // 1. Indexable
  // 2. Well defined order
  val aSeq = Seq(1,2,3,5)
  aSeq.foreach(println)

  // Range
  val aRange = 1 until 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println(x))

  // Lists
  // Linear Immutable LinkedList
  var aList = List(3,4,6,4)

  // prepend and append
  var nList = 35 +: aList :+ 33
  nList.foreach(println)

  // List fill
  var tList = List.fill(4)("test")
  println(tList)
  println(tList.mkString(" - "))

  // Sealed has 2 subtypes
  // class :: and object Nil

  // Arrays
  // Mutable List
  var array = Array(1,2,4)
  array(2) = 4
  array.foreach(println)

  // Arrays and Seq
  var anSeq: Seq[Int] = array // Implicit conversion

  // Vector
  // Immutable Sequence
  // Faster than Array or List
  var vector = Vector(12,3,4)
  vector.foreach(println)






}
