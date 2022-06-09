package com.cx.Test9

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/08 10:20
 */
object Test02_OtherList {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(0,1,3,4)
    val list1:List[Int] = List(3,4,5,6)
    //获取集合的头
    println(list.head)

    //获取集合的尾 （不是头的就是尾）
    println(list.tail)

    //集合最后一个数据
    println(list.last)

    //集合初始数据（不包含最后一个）
    println(list.init)

    //反转
    println(list.reverse)

    //取前（后）n 个元素
    println(list.take(3))
    println(list.takeRight(3))

    //去掉前（后）n 个元素
    //println(list.drop(1))
    //println(list.dropRight(1))

    //并集
    println(list.union(list1))
    //交集
    println(list.intersect(list1))
    //差集
    println(list.diff(list1))
    //拉链
    println(list.zip(list1))
    //窗

  }
}
