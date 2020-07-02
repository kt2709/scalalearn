package lectures.part2oops

object NovelWriter extends App {
  val author = new Writer("Arun", "Puppala", 1950)
  println(author.getFullName())

  val novel = new Novel("Arun", 2000, author)
  println(novel.getAuthorAge())
  println(novel.isWrittenBy(author))
  println(novel.copy(2040))

  val counter = new Counter
  counter.inc(10).print
  counter.inc.dec.inc.print
}

class Writer(fname: String, lname: String, val year: Int){

  def getFullName():String = this.fname+" "+this.lname

}

class Novel(name: String, year: Int, author: Writer){

  def getAuthorAge():Int = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int):Novel = new Novel(name, newYear, author)
}

class Counter(val count:Int = 0){
  // Immutability
  def inc =  new Counter(count+1)
  def dec = new Counter(count-1)

  //def increment(n:Int) = new Counter(count+n)
  def inc(n:Int):Counter = {
    if(n<=0) this
    else inc.inc(n-1)
  }
  def dec(n:Int):Counter = {
    if(n<=0) this
    else dec.dec(n-1)
  }

  def print() = println(count)
}