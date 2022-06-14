package Test7

import scala.collection.mutable.ArrayBuffer

object Test02 {
  def main(args: Array[String]): Unit = {
    /**
     * 可变数组转为不可变数组
     */
    val arr = ArrayBuffer(23,56,98)

    val arr1 = arr.toArray
    println(arr1.mkString(" "))


    /**
     * 不可变数组转为可变数组
     */

    val arr2 = arr1.toBuffer
    println(arr2)
  }

}
