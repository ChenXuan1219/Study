package Test7

 /**
 * 定义 val array = new Array[Int](10)
 * 不可变数组
 * 数组对象存放的地址,对象的大小,占据的空间不能改变
 */
object Test01_Immutable_Array {
  def main(args: Array[String]): Unit = {
    //1.创建数组

    // 方式一
    val arr: Array[Int] = new Array[Int](10)
    println(arr)

    //1.方式二
    val arr2 = Array(1, 2, 3, 4, 5)

    //2.访问元素

    arr2(0) = 0
    println(arr2(0))
    println("==============")

    /**
     * 1.遍历数组
     */
    for (i: Int <- 0 until arr2.length) {
      print(arr2(i) + " ")
    }
    println()
    println("==============")

    /**
     * 2.增强for循环
     */
    for (elem <- arr2) println(elem)
    println("==============")

    /**
     * 3.迭代器
     */
    val iterator = arr2.iterator
    while (iterator.hasNext) println(iterator.next())
    println("==============")

    /**
     * 4.调用foreach方法
     */
    //1.先定义函数
    arr2.foreach((elem: Int) => println(elem))

    arr2.foreach(println)

    /**
     * 5.元素转为String
     */
    println(arr2.mkString("--"))
    println("======")

    /**
     * 添加元素
     *
     */

      //往最后面添加元素
    val ints = arr2.:+(73)
    println(arr2.mkString("-"))
    println(ints.mkString("-"))
    println("======")
      //往最前面添加元素
    val int1 = ints.+:(30)
    println(ints(0))
    println(int1.mkString(" "))
    println("======")


    //如果函数名以":"结尾,离:近的为对象


    val int2 = int1 :+(12)
    println(int2.mkString(" "))

    val int3 = 29 +: 28 +: int1 :+ 12
    println(int3.mkString(" "))

   }


  }

