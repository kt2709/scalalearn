package lectures.part3fp

object TuplesMaps extends  App {

  // Tuple - Immutable
  val aTuple = new Tuple1("a",1)
  println(aTuple)

  val nTuple = ("a",1) // same as above
  println(nTuple)

  println(nTuple._1) // Access
  println(nTuple.copy(_1 = 0))
  println(nTuple.toString)

  println('a' -> 1) // ('a', 1)


  // Maps
  val aMap = Map()

  val phoneBook = Map(("Jim", 433), ("Arun", 34343), "test" -> 3434).withDefaultValue(-1) // a -> b is sugar for (a,b)
  println(phoneBook)

  val aList = List(("Jim", 433), ("Arun", 34343))
  println(aList.toMap)

  // Map Ops
  phoneBook.contains("Arun")
  println(phoneBook("dsfasd"))

  // Add new pair
  val pair = "Jaffa" -> 4343
  val nPhonebook = phoneBook + pair
  println(nPhonebook)

  // Functions on map - map, filter, flatmap
  println(nPhonebook.map(pair => pair._1.toLowerCase() -> pair._2))

  println(nPhonebook.filter(pair => pair._1.startsWith("J")))

  println(nPhonebook.filterKeys(x => x.startsWith("J")))

  println(nPhonebook.mapValues(_ * 10))

  // Conversions
  println(nPhonebook.toList)

  // Groupby
  val names = List("James", "Jim", "Angela")
  println(names.groupBy(_.charAt(0)))





}
