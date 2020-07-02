package lectures.part3fp

import java.util.Random

object Options extends App {

  // Some and None are options.
  // Instead of assigning nulls for unknown, use Option.
  val option1 = Some(4)
  val option2 = None

  println(option1)

  def unsafemethod(): String = null

  // var result = Some(null) // WRONG USAGE
  val result = Option(unsafemethod()) // will get Some("valid value") or None
  println(result)

  // chained methods
  def backupmethod(): String = "valid value"
  val chainedResult = Option(unsafemethod()).orElse(Option(backupmethod()))
  println(chainedResult)

  // Better unsafe and backup methods - Return option in API calls
  def betterUnsafemethod(): Option[String] = None
  def betterBackupmethod(): Option[String] = Some("a valid value")

  val betterChainedresult = betterUnsafemethod() orElse betterBackupmethod()
  println(betterChainedresult)

  // Functions on optinos
  println(option1.isEmpty)
  println(option1.get) // Never use it

  // map, flatmap and filter
  println(option1.map( _ * 2 ))
  println(option1.filter( _ > 10 ))
  println(option1.flatMap(x => Option(x * 10)))


  val config: Map[String, String] = Map(
    "host" -> "192.158.2.2",
    "port" -> "80"
  )

  class Connection{
    def connect = "Connected"
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

 // Handling if host exits and then port exists etc..can be written as follows

  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port)
        .map(connection => connection.connect))).foreach(println)

// Using for-comprehension

  val status = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host,port)
  } yield connection.connect

  status.foreach(println)
}

