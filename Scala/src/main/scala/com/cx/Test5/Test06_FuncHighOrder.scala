package com.cx.Test5

object Test06_FuncHighOrder {
  def main(args: Array[String]): Unit = {

    //函数组为参数进行传递
    def dealEval(op: (Int,Int)=>Int ,a: Int, b: Int): Int = {
      op(a,b)
    }

    def add(a: Int,b: Int): Int = {
      a + b
    }

    println(dealEval(add,12,35))
    println(dealEval((a , b)=> a + b , 12, 35))
    println(dealEval(_ + _,12,35))


    println("=========")

    //函数可以作为函数的返回值返回
    def f5(): Int=>Unit = {
      f6
    }
    def f6(a:Int):Unit={
      println("f6调用")
    }

    println(f5()(25))
  }



}
