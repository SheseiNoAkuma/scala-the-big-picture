package classes

class Math {
  private val max = 100
}

object Math {
  def sum(a: Int, b: Int): Int = a + b
  def getPrivate: Int = new Math().max
}
