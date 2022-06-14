package Test7

object Test04_List {
  def main(args: Array[String]): Unit = {
    /**
     * 创建不可变List
     */
    val list1 = List(1, 2, 3)
    println(list1)

    /**
     * 访问和遍历
     */
    println(list1(1))
    list1.foreach(println)
    println("========")

    /**
     * 添加元素
     */
      //方式一
    val list2 = list1 :+ 4
    val list3 = 0 +: list1

    println(list2)
    println(list3)
    println(list1)
    println("========")
    //方式二
    val list4 = list2.::(-1)
    println(list4)
    println("========")
    val list5 = Nil.::(1,2)
    println(list5)
    val list6 = 1 :: 2 :: 3 :: Nil
    println(list6)
    println("========")
    /**
     * 链表合并
     */


    val list8 = list5 :: list6
    //  List(List((1,2)), 1, 2, 3)
    println(list8)
    println("========")

    val list9 = list1 ::: list2
    println(list9)

    val list10 = list1 ++ list2
    println(list10)

    println("==============")









  }
}
