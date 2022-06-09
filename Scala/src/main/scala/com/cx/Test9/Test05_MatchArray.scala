package com.cx.Test9

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/09 15:10
 */
object Test05_MatchArray {
  def main(args: Array[String]): Unit = {
    for (arr <- Array(Array(0),Array(1,0),Array(0,1,0),Array(1,1,0,1))){
      val result = arr match {
        case Array(0) => "0"  //匹配Array(0) 这个数组
        case Array(x,y) => x + "," + y //匹配两个元素的数组
        case Array(0,_*) => "以0开头的数组"
        case _ => arr.sum
      }
      println("result= " + result)
      }
    }
}
