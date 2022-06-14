package Test4

import scala.io.StdIn

object Test01_ifElse {
  def main(args:Array[String]):Unit ={

    val i = 213

    val result : AnyVal =
      if (i > 0 && i < 10){
        1.2213
      }else if(i >= 10 && i <= 20) {
        13
      }else{
        i
      }

    println(result)



  }
}
