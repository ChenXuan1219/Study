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
object Spark15_RDD_Operator_Transform_foldByKey {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - foldByKey
     *  分区间和分区内计算规则相同
     */


    sc.makeRDD(List(("a",1),("a",2),("a",3),("a",4)),2).foldByKey(0)(_+_)




 
    sc.stop()


  }

}
