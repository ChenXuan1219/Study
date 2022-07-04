package Test7

import scala.collection.mutable.ArrayBuffer

object Test02_Array_canChange {
  /**
   * 可变数组
   * Seq
   * |-->IndexedSeq   |-->ArrayBuffer
   * |-->Buffer       |-->ArrayBuffer
   * 同时具有两个特称
   * @param args
   */
  def main(args: Array[String]): Unit = {
     //创建可变数组  不用穿参数,不用传泛型
    //默认数量为16

    //方式一
    var arr1 : ArrayBuffer[Int] = new ArrayBuffer[Int]()
    arr1 = ArrayBuffer(1,2)
    //方式二 使用伴生对象
    var arr2  = ArrayBuffer(1,2,3,4,5)
    0 +: arr2 :+ (6)

    arr2(0) = 0
    println(arr2)
    println(arr2.length + "\n" + arr2.mkString(" "))


    //访问元素

    println(arr2(0))

    //添加元素
    //使用   往后加 +=  append

    val ints = arr2 += 6
    arr2.append(7)
    println(arr2)
    println(arr2 == ints)
    println("======")

    // 往前加 +=:   prepend

    1 +=: arr2
    println(arr2)

    arr2.prepend(1)

    //在某一个位置添加
    val arr3 = ArrayBuffer(4,5)
    arr1.insert(arr1(1),3)
    println(arr1)
    arr1.insertAll(arr1(2),arr3)


    println(arr1)




    //删除元素
    println("=====")
    println("before"+arr1)
    println(arr1.length)

    arr1.remove(0,arr1.length-1)

    //arr1.remove(arr1(1))
    println(arr1)







  }
}
