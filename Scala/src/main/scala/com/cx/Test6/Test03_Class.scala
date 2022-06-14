package Test6

object Test03_Class {
  def main(args: Array[String]): Unit = {
    val student = new Student
    student.a = 2
    println(student.a+ "  "+student.b)
    println((new Student).a)


    println((new stu))

  }

}

class Student{

  protected var pro:Int = 5
  var a : Int = _
  var b : String= _

  protected def met ={
    println(pro)
  }
}

class stu extends Student{

}
