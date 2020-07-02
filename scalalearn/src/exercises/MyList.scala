package exercises

abstract class MyList {
  def head:Int
  def tail:MyList
  def isEmpty:Boolean
  def add(x:Int):MyList
  def printElements:String
  override def toString:String = "[" + printElements + "]"
}

object Empty extends MyList{
  def head:Int = throw new NoSuchElementException
  def tail:MyList = throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add(x:Int):MyList = new Cons(x, Empty)
  def printElements:String = ""
}

class Cons(h:Int, t:MyList) extends MyList{
  def head:Int = h
  def tail:MyList = t
  def isEmpty:Boolean = false
  def add(x:Int):MyList = new Cons(x, this)
  def printElements:String = {
    if(t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App{
  val list = new Cons(1, new Cons(2, Empty))
  println(list.toString)
  println(list.tail.head)

}