package com.cx.spark.core.rdd.acc

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/15 15:30
 */
object Spark01_Acc {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("WordCount"))

    val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4),4)

    //rdd.groupBy(_)



    val sumAcc: LongAccumulator = sc.longAccumulator("sum")

    rdd.foreach(num => {sumAcc.add(num)})

    println(sumAcc.value)

  }
}
