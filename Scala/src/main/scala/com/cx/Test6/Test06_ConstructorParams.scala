package Test6

object Test06_ConstructorParams {
  def main(args: Array[String]): Unit = {
    println(new Student3("cx",16))
  }
}

//
//无参数构造
class Student2{
  //需要单独定义属性
  var name:String = "cx"
}

class Student3(var name:String,val age:Int = 15)

class Student4(val name:String = "cx",val age:Int = 15){
}