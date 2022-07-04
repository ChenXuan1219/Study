package com.cx.Test5

object Test05_lambda {
  def main(args: Array[String]): Unit = {


    //表示 以String为参数,Unit作为返回值的 函数
    val stringToUnit: String => Unit = (name : String) => {5}
    val fun = stringToUnit
    fun("cx")
    println("========")

    //当成参数传给其他参数
    def f(func: String => Unit): Unit = {
      func("cx")
    }

    //将函数作为参数相当于,要做什么事当作参数
    //"cx" 做为  stringToUnit 函数的参数

    println(f(fun))

    println("========")


    //匿名函数的简化原则
//    1.参数的类型可以省略,会根据形参进行自动的推到

    f((name: String) => {
      println(name)
    })

    f(name => println(name))

//    2.类型省略之后,发现只有一个参数,则圆括号可以省略,其他情况,没有参数和参数超过1的永远不能省略圆括号

    f( name => {
      println(name)
    })
//    3.匿名函数如果只有一行,大括号可以省略

    f( name => println(name))

//    4.如果参数只会出现一次,则参数省略且后面参数可以用_替代
    f(println(_))

    // 5.如果可以推断出,当前传入的println是一个函数,而不是调用语句,可以直接省略下划线
    f(println)

  println("========")

  def function ( fun : (Int,Int) => Int) : Int ={
    fun(1,2)
  }


    println(function((a: Int, b: Int) => a + b))
    println(function(_ + _))

    println(function((a: Int, b: Int) => a - b))
    println(function(_ - _))

    println("=========")



  }
}
