package Test6

object Test08_Abstract {
  def main(args: Array[String]): Unit = {
    val stu1 = new per1
    stu1.eat()

    var stu2 = new Stu1 {
      override var age: Int = 5

      override def sleep(): Unit = {
        println(name)
      }
    }
    stu2.sleep()
    println(stu2.age)
  }
}

abstract class Stu1{
  //非抽象属性
  val name:String = "STU1"

  //抽象属性
  var age : Int

  def eat() = {
    println("eat")
  }

  def sleep(): Unit
}

class per1 extends Stu1{
  var age: Int = 18

  def sleep(): Unit = {
    println("per1")
  }

  override def eat(): Unit = {
    super.eat()
    println("stu eat")
  }
}