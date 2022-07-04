package Test5

import scala.annotation.tailrec
import scala.util.control.Breaks

object Test10_ {
  def main(args: Array[String]): Unit = {

    def fun(num: Int) : Int = {
      if (num == 0) return 1
      fun(num - 1 ) * num
    }

    def fun2(n: Int): Int = {
      @tailrec
      def loop(n: Int,curr: Int):Int = {
        if (n == 0) return curr
        loop(n-1,curr * n)
      }
      loop(n,1)
    }

    println(fun(4))
    println(fun2(2))
  }


}
