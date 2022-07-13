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
object Spark05_RDD_Operator_Action_foreach {
  def main(args: Array[String]): Unit = {
    /**
     * 行动算子：出发作业执行的方法
     * 底层调用的是runJob方法
     */
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Action"))

    /**
     * foreach
     *
     *
     */
    val rdd: RDD[Int] = sc.makeRDD(List(2, 1, 3, 4),2)

    //在driver端内存集合的循环遍历方法
    rdd.collect().foreach(println)
    println("=========")


    //在executor端内存数据打印
    //分布式打印，并行打印，无顺序
    rdd.foreach(println)

    rdd.foreach(
      num => {
        println( (new User).name + num)
      }
    )
  }

  /**
   * 样例类在编译时，会自动混入序列化特质（实现可序列化接口）
   */
  case class User(){
    var name : String = "cx"
  }

}
