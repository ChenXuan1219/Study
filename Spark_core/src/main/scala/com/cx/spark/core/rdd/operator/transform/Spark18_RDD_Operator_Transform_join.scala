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


object Spark18_RDD_Operator_Transform_join {
  def main(args: Array[String]): Unit = {

    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))

    /**
     *   TODO算子 - join
     *
     * 不同数据源  的数据，相同key的value会连接在一起，形成元祖
     * 如果两个数据源中的key没有匹配上，那么数据不会出现在结果中
     * 如果由多个相同的key，会依次匹配，会出现笛卡尔成绩，数据量增多
     *
     * leftOuterJoin 类似左连接
     */


    val rdd1: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3),("a",4),("d",4)))

    val rdd2: RDD[(String, Int)] = sc.makeRDD(List(("a", 4), ("b", 5), ("c", 6)))

    val joinRDD: RDD[(String, (Int, Int))] = rdd1.join(rdd2)

    val leftJoin: RDD[(String, (Int, Option[Int]))] = rdd1.leftOuterJoin(rdd2)

    val rightJoin: RDD[(String, (Option[Int], Int))] = rdd1.rightOuterJoin(rdd2)

    joinRDD.collect().foreach(println)

    leftJoin.collect().foreach(println)

    rightJoin.collect().foreach(println)


 
    sc.stop()


  }

}
