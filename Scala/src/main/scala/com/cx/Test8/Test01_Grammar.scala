package com.cx.Test8

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/10 10:44
 */
object Test01_Grammar {
  def main(args: Array[String]): Unit = {
    val f = foo(1)
    println(f)

    val f1 = foo _
    println(f1)
  }
  def foo(i: Int): Int = {
    println("foo...")
    i
  }
}
