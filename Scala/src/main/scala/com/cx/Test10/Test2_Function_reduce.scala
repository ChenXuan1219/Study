package com.cx.Test10

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/06 18:52
 */
object Test2_Function_reduce {
  def main(args: Array[String]): Unit = {
    val list = List(0,1,2,3)

    //1.reduce
    //2.flod



    /**
     * reduce
     */
    list.reduce((a:Int,b:Int) => a + b)
    list.reduce(_ + _)
    val i = list.sum
    println(i)

    println(list.reduceLeft(_ - _))     // 0 - 1 - 2 - 3
    println(list.reduceRight(_ - _))    // 0 - ( 1 - ( 2 - (3)))


    /**
     * flod :
     */

  }
}
