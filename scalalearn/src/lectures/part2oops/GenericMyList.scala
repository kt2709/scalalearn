package lectures.part2oops

abstract class MyList[+A] {
  def head:A
  def tail:MyList[A]
  def isEmpty:Boolean
  def add[B >: A](x:B):MyList[B]
  def printElements:String
  override def toString:String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A,B]): MyList[B]
  def filter(myPredicate: MyPredicate[A]):MyList[A]
}

object Empty extends MyList[Nothing]{
  def head:Nothing = throw new NoSuchElementException
  def tail:MyList[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add[B >: Nothing](x:B): MyList[B] = new Cons(x, Empty)
  def printElements:String = ""

  def map[B](transformer: MyTransformer[Nothing,B]): MyList[B] = Empty
  def filter(myPredicate: MyPredicate[Nothing]):MyList[Nothing] = Empty
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

  def map[B](transformer: MyTransformer[A,B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }
  def filter(myPredicate: MyPredicate[A]):MyList[A] = {
    if(myPredicate.filter(h)) new Cons(h, t.filter(myPredicate))
    else t.filter(myPredicate)
  }
}

trait MyPredicate[-A]{
  def filter(elem: A): Boolean
}

trait MyTransformer[-A, B]{
  def transform(elem: A): B
}

object GenericMyList extends App{
  val listofIntegers: MyList[Int] = new Cons(1, new Cons(2, Empty))
  println(listofIntegers.toString)

  val listStrings: MyList[String] = new Cons("a", new Cons("b", Empty))
  println(listStrings.toString)

  println(listofIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listofIntegers.filter(new MyPredicate[Int] {
    override def filter(elem: Int): Boolean = elem % 2 == 0
  }).toString)


}