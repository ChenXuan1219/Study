package Test6

object Test07_DynamicBind {
  def main(args: Array[String]): Unit = {
    var car:Audi = new Audi

    println(car.name)
    car.Hi
  }
}


class Car {
  val name: String = "Car"
  def Hi ={
    println(name)
  }
}

class Audi extends Car{
  override val name: String = "Audi"

  override def Hi: Unit = {
    println(name)
  }
}
