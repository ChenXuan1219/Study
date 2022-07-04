package Test6

object Test04_ClassForAccess {

}

class Person{
  private var idCord: String = "3456"
  protected var name: String ="cx"
  var sex: String = "man"
  private [Test6] var age: Int = 18

  def printInfo = {
    println(s"$idCord $name $sex $age")
  }
}
