package Test6

object Test04_Access {
  def main(args: Array[String]): Unit = {

    val person:Person = new Person()
    val worker:Worker = new Worker()

    person.printInfo
    worker.printName
    worker.printInfo

  }
}


//定义子类
class Worker extends Person{
  override def printInfo: Unit = {
    println(s"$name $sex $age")
  }
  def printName = {
    println(name)
  }

}