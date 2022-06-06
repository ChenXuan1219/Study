package com.cx.Test10

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/06 16:37
 */


object test1 {
  def main(args : Array[String]): Unit ={

    //1.过滤
    val list = List(0,1,2,3)
    val evenList = list.filter(_ % 2 == 0)

    println(evenList)
    println("======")
    //2.每一个元素做操作
    //把集合中每个元素乘2
    println(list.map(_ * 2))
    println(list.map(x => x * x))
    println("====")

    //3.扁平化
    val nestedList:List[List[Int]] = List(List(1,2,3),List(4,5),List(6,7,8,9))

    val flatList = nestedList(0) ::: nestedList(1) ::: nestedList(2)

    println(nestedList)
    println(flatList)

    val flatList2 = nestedList.flatten
    println(flatList2)


    //4.分组
    val groupMap : Map[String,List[Int]] = list.groupBy(data => {
      if(data % 2 == 0) "偶数" else "奇数"
    }
    )
    println(groupMap)


    val wordList = List("aa","bb","cc","dd","ab")
    println(wordList.groupBy(_ . charAt(0)))

  }
}