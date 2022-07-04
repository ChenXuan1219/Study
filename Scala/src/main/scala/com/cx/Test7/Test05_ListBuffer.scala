package Test7

import scala.collection.mutable.ListBuffer

object Test05_ListBuffer {
  def main(args: Array[String]): Unit = {
    /**
     * 1.创建可变List
     */
    val list1: ListBuffer[Int] = new ListBuffer[Int]()
    list1.insert(0,1,2,3,-4)
    println(list1.max )
    println(list1.product)
    val list2 = ListBuffer(1,2,3)
    println(list2)

    /**
     * 2.添加元素
     */
    list2.append(4,5)
    list2.prepend(0)
    println(list2)
    list2.insert(0,-1)
    println(list2)
    println("========")
    -2 +=: list2 += 6 += 7
    println(list2)


    println("===============")
    println(list1)
    println(list2)
    list1 ++= list2  //list1 变
    list2 ++=: list2 //list2 变
    println(list1)
    println(list2)



    /**
     * 修改元素
     */
    list1(0) = 3
    list1.update(1,3)

    /**
     * 删除
     */
    list1.remove(1) //指定删除哪个位置的值
    list2 -= 25 //指定删除值

  }
}
