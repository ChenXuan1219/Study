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
object Spark02_RDD_Operator_Action_aggregate {
  def main(args: Array[String]): Unit = {
    /**
     * 行动算子：出发作业执行的方法
     * 底层调用的是runJob方法
     */
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Action"))

    /**
     * aggregate
     *  初始值：参与分区内和分区间的计算
     */
    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),2)

    val i: Int = rdd.aggregate(0)(_ + _, _ - _)


    /**
     * fold：分区间和分区内的计算规则相同
     */
    rdd.fold(0)(_+_)

    println(i)




  }

}
