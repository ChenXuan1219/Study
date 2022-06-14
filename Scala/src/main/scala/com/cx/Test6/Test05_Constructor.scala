package Test6

object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    val student1 = new Student1
    println("============")
    student1.student1()
    println("============")

    val student2 = new Student1("cx")
    println("============")
    val student3 = new Student1("cx",25)
    println("============")

  }

}

class Student1(){
  //定义属性
  var name: String = _
  var age: Int = _
  println("主构造器被调用")

  def this(name: String){
    this() //直接调用主构造器
    println("2.辅助构造方法一被调用")
    this.name = name
    println(s"name: $name age: $age")
  }

  def this(name:String,age:Int){
    this(name)

    println("3.辅助构造方法二被调用")
    this.age = age
    println(s"name: $age age: $age")

  }

  def student1():Unit = {
    println("一般方法被调用")
  }





}
