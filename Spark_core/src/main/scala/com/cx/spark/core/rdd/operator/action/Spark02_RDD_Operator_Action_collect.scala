package com.cx.spark.core.rdd.operator.action

import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/07 15:33
 */
object Spark02_RDD_Operator_Action_collect {
  def main(args: Array[String]): Unit = {
    /**
     * 行动算子：出发作业执行的方法
     * 底层调用的是runJob方法
     */
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Action"))

    /**
     * collect
     * 在驱动程序中，以数组Array的形式返回数据集的所有元素
     * 方法会将不同分区的数据按照分区顺序采集到Driver端内存中，形成数组
     */
    val ints: Array[Int] = sc.makeRDD(List(1, 2, 3, 4)).collect()

    val str: String = ints.mkString(",")

    sc.stop()


  }

}
