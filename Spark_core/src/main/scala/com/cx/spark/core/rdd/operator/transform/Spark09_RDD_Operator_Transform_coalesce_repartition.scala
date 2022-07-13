package com.cx.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
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
object Spark09_RDD_Operator_Transform_coalesce_repartition {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - coalesce
     *   根据数据量缩减分区，，用于大数据集过滤后，提高小数据集的执行效率，
     *   当spark程序中，存在过多小任务后，可以通过coalesce方法，收缩合并分区，减少分区的个数，减少任务调度成本
     *
     *   默认不会将分区打乱重新分组
     *   shuffle默认为false
     *   shuffle取true可以让数据均衡分布
     *
     *   分区减少 coalesce
     *   分区均衡 shuffle
     *   分区增多 repartition
     */


    val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 3)

    val NewRDD1: RDD[Int] = rdd1.coalesce(2,true)

    NewRDD1.saveAsTextFile("output1")

    val rdd2: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 2)

    val NewRDD2: RDD[Int] = rdd2.repartition(3)
    

    sc.stop()


  }

}
