package Test6

object Test13_Trait {
  def main(args: Array[String]): Unit = {
   val student = new Student13
    student.sayHello
    student.play()
    println(student.name + " " + student.age)


  }


}

class Person13{
  val name: String = "cx"
  val age: Int = 23
  def sayHello : Unit = {
    println(s"$name + $age + from Person13")
  }
}

class Student13 extends Person13 with Young {

  //重写冲突属性
  override val name: String = "student"
  override val age: Int = 25
  //实现抽象方法
  def dating(): Unit = println(s"Student is $name is dating")

  def study: Unit = println(s"Student is $name is studying")

  override def sayHello: Unit = {
    super.sayHello
    println(s"hello from :student$name")
  }
}

trait Young{
  //声明抽象和非抽象属性
  val age : Int

  val name: String = "young"

  //声明抽象和非抽象方法
  def play() : Unit = {
    println("young people")
  }

  def dating() : Unit

}
