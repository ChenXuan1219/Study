package Test5

object Test03_FunctionParameter {
  def main(args: Array[String]): Unit = {
//    1.可变参数
    def f1(str:String*): Unit = {
      println(str)
    }
    f1("aaa","bbb")
    println("=========")
//    2.如果参数列表,可变参数放在最后
    def f2(name:String,age:Int*): Unit ={
      println(name + age)
    }
    f2("cx",12,23,43)
    println("=========")

//    3.参数默认值,一般将有默认值的参数放置在列表的后面
    def f3(name: String = "cx"): Unit ={
      println(name)
    }
    f3()
    f3("cx2")
    println("=========")
//    4.带名参数
    def f4(name: String = "cx1",age: Int) : Unit = {
      println(s"name = ${name},age = $age")
    }
    f4("cx",12)
    f4(age = 23,name = "lyr")
    f4(age = 1121)

  }

}
