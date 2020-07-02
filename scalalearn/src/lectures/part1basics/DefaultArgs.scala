package lectures.part1basics

object DefaultArgs  extends  App {

  def aFunction(x: String = "jpg", y: Int) = println("xxxx")

  aFunction(y=20,x="pm")

}
