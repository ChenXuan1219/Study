package com.cx.spark.core.rdd.operator.transform

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
     *
     */

    //求平均值
    sc.makeRDD(List(("a",1),("a",2),("a",3),("a",4)),2)
      .aggregateByKey(0)(
      (x,y) => math.max(x,y),
      (x,y) => math.min(x,y)
    ).collect().foreach(println)

    sc.makeRDD(List(("a",1),("a",2),("b",3),("b",4))).aggregateByKey((0,0))(
      (t,v) => {
        (t._1 + v,t._2 + 1)
      },
      (t1,t2) => {
        (t1._1 + t2._1 ,t1._2 + t2._2)
      }
    )





 
    sc.stop()


  }

}
