package com.cx.Test5

object Test02_FuncDefine {
  def main(args: Array[String]): Unit = {
//    1.无参,又返回值
    def f1() : Unit = {
      println("no args,Unit")
    }
    println(f1())

    println("==============")
//    2.无参,有返回值
    def f2() : Int = {
      12
    }
    println(f2())
    println("==============")
//    3.有参,无返回值
    def f3(name: String):Unit = {
      println("有参无返回值:"+name)
    }
    println("返回值为: "+f3("cx"))
    println("==============")
//    4.有参,有返回值
    def f4(name:String): String = {
      println("有参有返回值: "+name)
      "cx"
    }
    println("有参有返回值: "+f4("cx"))
    println("==============")
//    5.多参,无返回值
    def f5(name: String,age: Int): Unit = {
      println(s"多参,无返回值: $name + $age")
    }
    println("多参,无返回值: "+ f5("cx",23))
    println("==============")
//    6.多参,有返回值
    def f6(age: Int): Int = {
      age
    }
    println("多参,有返回值: "+ f6(5))
    println("==============")


    val fun: Int=>Int = f6
    println(fun)

    println("=============")
    def f7(): Unit ={
      println("f7")
    }
    val fun1 = f7 _
    println(fun1)
  }

}
