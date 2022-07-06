package com.cx.spark.core.temporary

import org.apache.spark.{SparkConf, SparkContext}
/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/04 15:05
 */

/**
 * 将同一个分区的数据直接转化为相同类型的内存数据进行处理。分区不变
 */
object Spark15_RDD_Operator_Transform_aggregateByKey {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - aggregateByKey
     *  第一个参数列表
     *    需要传递一个参数，表示初始值,主要用于碰见第一个key时候，和value进行分区内计算
     *  第二个参数列表
     *    第一个参数表示分区内计算规则
     *    第二个参数表示分区间计算规则
     *
     */


    sc.makeRDD(List(("a",1),("a",2),("a",3),("a",4)),2)
      .aggregateByKey(0)(
      (x,y) => math.max(x,y),
      (x,y) => math.min(x,y)
    ).collect().foreach(println)





 
    sc.stop()


  }

}
