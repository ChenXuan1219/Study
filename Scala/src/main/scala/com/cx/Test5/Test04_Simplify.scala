package com.cx.Test5

object Test04_Simplify {
  def main(args: Array[String]): Unit = {
    def f0(name: String): String = {
      return name
    }
//    1.return可以省略
    def f1(name: String): String = {
       name
    }
    f1("f1")
//    2.函数只有一行内容,{}可以省略
    def f2(name: String): String = name
    f2("f2");

//    3.返回值类型如果能推断出来,那么可以省略

    def f3(name: String) = name

//    4.如果有return,则不能省略返回值类型,必须指定

                         //不能省略String
    def f4(name: String) : String = {
      return name
    }

//    5.如果函数声明Unit,即使函数体中使用return也是Unit

    def f5(name: String) = println(name)

    println(f5("cx"))
    println("===============")

//    6.如果函数是无返回值类型,可以省略等号

    def f6(): String = {
      "cx"
    }
    def f7(): Unit = {

    }
    println(f6())
    println(f6)
    println(f7)
    println("===============")

//    7.如果函数无参,但是声明了参数列表,调用时,小括号,可以不加

    def f8 : Unit = {}
    println(f8)
    println("===============")

//    8.如果函数没有参数列表,那么小括号可以省略,调用时,小括号必须省略

    def f9(name: String): Unit = {
      println(name)
    }
    f9("cx")
    println("===============")

//    9.如果不关心名称,只关心逻辑处理,那么函数名def可以省略

    //匿名函数,lambda表达式
    (name : String) => println



  }
}
