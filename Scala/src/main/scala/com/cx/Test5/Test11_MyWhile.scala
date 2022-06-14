package Test5

import java.util.concurrent.locks.Condition

object Test11_MyWhile {
  def main(args: Array[String]): Unit = {

    var n = 10

    //1.常规while循环
    while (n >= 1){
      println(n)
      n -= 1
    }

    //2.用闭包实现一个函数,将代码块作为参数传入,递归调用
    def myWhile(condition: Boolean) = {
      def doLoop(op: =>Unit): Unit = {
        if(condition){
          op

        }
      }
    }

  }

}
