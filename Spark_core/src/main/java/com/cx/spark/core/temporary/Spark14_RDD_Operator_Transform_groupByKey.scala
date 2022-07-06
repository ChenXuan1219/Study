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
object Spark14_RDD_Operator_Transform_groupByKey {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - groupByKey
     *    分区会被打乱重做，有shuffle
     *    相同的key的数据进行value数据的聚合操作
     */

    //https://sparblog.csdn.net/do_yourself_go_on/article/details/76033252

    sc.makeRDD(List(("a",1),("a",2),("a",3),("b",4)),2).saveAsTextFile("output")
    sc.makeRDD(List(("a",1),("a",2),("a",3),("b",4)),2).groupByKey().saveAsTextFile("outputByKey")



 
    sc.stop()


  }

}
