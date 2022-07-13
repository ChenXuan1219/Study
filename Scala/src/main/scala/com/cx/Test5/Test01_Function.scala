package com.cx.Test5

object Test01_Function {
  def main(args: Array[String]): Unit = {
    //定义函数
    def sayHi(name: String): Unit = {
      println("hi "+name)
    }

    sayHi("cx")

    Test01_Function.sayHi("lyr")


  }
  def sayHi(name: String): Unit = {
    println("hi "+name)
  }


}
