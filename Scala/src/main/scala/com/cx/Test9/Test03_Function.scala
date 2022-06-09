package com.cx.Test9

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/08 11:29
 */
object Test03_Function {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(0,1,2,3,4)
    //求和
    println(list.sum)
    //求乘积
    println(list.product)
    //最大值
    println(list.max)
    //最小值
    println(list.min)
    //排序
    println(list.sortBy(x => x))
  }
}
