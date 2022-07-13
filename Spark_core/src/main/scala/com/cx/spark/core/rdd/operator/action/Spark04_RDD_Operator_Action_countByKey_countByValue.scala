package com.cx.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/07 15:33
 */
object Spark04_RDD_Operator_Action_countByKey_countByValue {
  def main(args: Array[String]): Unit = {
    /**
     * 行动算子：出发作业执行的方法
     * 底层调用的是runJob方法
     */
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Action"))

    /**
     * countByKey : 统计key的出现次数
     *
     *
     * countByValue:统计每个数出现次数
     */

    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),2)

    val intToLong: collection.Map[Int, Long] = rdd.countByValue()

    println(intToLong)

    println(sc.makeRDD(List(("a", 1), ("a", 1), ("a", 3))).countByKey())

    sc.stop()

  }

}
