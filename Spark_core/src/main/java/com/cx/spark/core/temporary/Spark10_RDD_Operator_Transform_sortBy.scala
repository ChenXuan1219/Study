package com.cx.spark.core.temporary

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
object Spark10_RDD_Operator_Transform_sortBy {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - sortBy
     *    第二个参数，true为升序，false为降序
     *
     */


    val rdd = sc.makeRDD(List(("b",1),("a",1),("c",1)),2)

    rdd.sortBy(t => t._1,false).collect().foreach(println)


    sc.stop()


  }

}
