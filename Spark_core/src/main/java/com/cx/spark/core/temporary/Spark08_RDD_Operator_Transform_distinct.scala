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
object Spark08_RDD_Operator_Transform_distinct {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - distinct
     *   根据指定的规则从数据集中抽取数据
     *
     *   如何去重
     *   scala的去重用的是hashset
     *
     *   rdd中：map(x => (x, null)).reduceByKey((x, _) => x, numPartitions).map(_._1)
     *   例如：List(1, 2, 3, 4, 1, 2, 3, 4)
     *
     * 1。map(x => (x, null))
     *   (1, null)，(2, null)，(3, null)，(4, null)，(1, null)，(2, null)，(3, null)，(4, null)
     * 
     *
     *
     *
     */


    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 1, 2, 3, 4))

    val rdd1: RDD[Int] = rdd.distinct()

    rdd1.collect().foreach(println)

    sc.stop()


  }

}
