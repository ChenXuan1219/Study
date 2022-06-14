package Test4

import scala.util.control.Breaks
import scala.util.control.Breaks._

object Test04_Break {
  def main(args: Array[String]): Unit = {

    try {
      for (i <- 0 until 5) {
        if (i == 3)
          throw new NullPointerException
        println(i)
      }
    } catch {
      case e: Exception =>
    }
    println("==========")
    Breaks.breakable(
      for (i <- 0 until 5) {
        if(i == 3)
          Breaks.break()
        println(i)
      }


    )

    println("=======")
    breakable(
      for (i <- 0 until 5) {
        if (i == 3)
          break()
        println(i)
      }
    )
  }





}



