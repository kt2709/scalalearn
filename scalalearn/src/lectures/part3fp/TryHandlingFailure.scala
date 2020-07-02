package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object TryHandlingFailure extends App{

  // Try is for wrapping around exceptions.
  // try-catch will throw and catch exceptions but Try will wrap around it with Success / Failure objects

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("dsafds"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException
  def backupMethod(): String = "a valid one"

  val result = Try(unsafeMethod())
  println(result)

  // Syntax Sugar
  val anotherFailure = Try {
    //code that might throw
  }

  // Utils
  println(aSuccess.isSuccess)

  // orElse
  val test = Try(unsafeMethod()) orElse Try(backupMethod())
  println(test)

  def betterUnsafemethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupmethod(): Try[String] = Success("343")

  val ftest = betterUnsafemethod() orElse betterBackupmethod()
  println(ftest)

  // map, flatmap and filter
  println(aSuccess.map(_*2))
  println(aSuccess.flatMap(x => Success(x*4)))
  println(aSuccess.filter(_ > 10))

  // Exercise
  val host = "193.3.4.4"
  val port = "80"
  def renderHTML(page: String) = println(page)

  class Connection{

    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html> .. </html>"
      else throw new RuntimeException("connection interrupted")
    }

    // Define Safe get method with Try
    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HTTPService{
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("port not available")
    }

    // Define safe get connection method
    def getSafeconnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // If you get the html from connection, render it
  HTTPService.getSafeconnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // For comprehension
  for{
    connection <- HTTPService.getSafeconnection(host, port)
    page <- connection.getSafe("/home")
  } yield renderHTML(page)

  // Equivalent code in try catch
  /*

    try{
      connection = HTTPService.getConnection(host, port)
      try{
        html = connection.get("/home")
        renderHTML(html)
      }catch(some exception){

      }
    }catch(some exception){

    }

   */
}
