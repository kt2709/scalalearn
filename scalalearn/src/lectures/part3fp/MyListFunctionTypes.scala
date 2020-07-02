package lectures.part3fp


abstract class MyList[+A] {
  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean
  def add[B >: A](x:B):MyList[B]
  def printElements:String
  override def toString:String = "[" + printElements + "]"

  // higher order function
  def map[B](transformer: A => B): MyList[B]
  def filter(myPredicate: A => Boolean):MyList[A]
}

object Empty extends MyList[Nothing]{
  def head:Nothing = throw new NoSuchElementException
  def tail:MyList[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add[B >: Nothing](x:B): MyList[B] = new Cons(x, Empty)
  def printElements:String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def filter(myPredicate: Nothing => Boolean):MyList[Nothing] = Empty
}

class Cons[+A](h:A, t:MyList[A]) extends MyList[A]{
  def head:A = h
  def tail:MyList[A] = t
  def isEmpty:Boolean = false
  def add[B >: A](x:B):MyList[B] = new Cons(x, this)
  def printElements:String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }
  def filter(myPredicate: A => Boolean):MyList[A] = {
    if(myPredicate(h)) new Cons(h, t.filter(myPredicate))
    else t.filter(myPredicate)
  }
}


object MyListFunctionTypes extends App{

  val listofIntegers: MyList[Int] = new Cons(1, new Cons(2, Empty))
  println(listofIntegers.toString)

  val listStrings: MyList[String] = new Cons("a", new Cons("b", Empty))
  println(listStrings.toString)

  println(listofIntegers.map(new Function1[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }).toString)

  println(listofIntegers.filter(new Function1[Int, Boolean] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }).toString)
}
