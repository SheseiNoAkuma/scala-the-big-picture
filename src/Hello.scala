import classes.CaseClassExample

object Hello extends App {
  println("Hello from scala")

  val hello: CaseClassExample = CaseClassExample.apply("Hello", 1)
  val other: CaseClassExample = hello.copy("Other")
  println(other)
  println(hello.copy(other = 2))

  private val maybeExample: Option[CaseClassExample] = Option.apply(hello)
  maybeExample.map(println(_))

  println(stringToInt("1"))
  println(stringToInt("what"))


  println(matchHello(hello))
  println(matchHello(other))

  def stringToInt(in: String) : Either[String, Int] = {
    try
      Right(in.toInt)
    catch {
      case e: NumberFormatException => Left("Error " + e.getMessage)
    }
  }

  def matchHello(evaluated: CaseClassExample) : Option[CaseClassExample] = {
    evaluated match {
      case CaseClassExample("Hello", _) => Option.apply(evaluated)
      case _ => Option.empty
    }
  }
}

