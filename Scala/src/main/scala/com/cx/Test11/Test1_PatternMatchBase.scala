package com.cx.Test11

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/06 19:26
 */
object Test1_PatternMatchBase {
  def main(args: Array[String]): Unit = {
    val x : Int = 2
    val y : String = x match {
      case 1 => "one"
      case 2 => "two"
      case _ => "None"
    }
      println(y)
    }
}
