package com.cx.spark.core.rdd.acc

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.OL
import org.apache.spark.rdd.RDD
import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/15 15:30
 */
object Spark02_Acc_WC {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("WordCount"))

    val rdd: RDD[String] = sc.makeRDD(List("hello cx", "hello spark", "hello"))

    //累加器

    //创建累加器对象
   /* //val wcAcc: MyAccumulator = new MyAccumulator()
    //向spark进行注册
    sc.register(wcAcc,"wordCountAcc")

    rdd.foreach(
      word => {
        wcAcc.add(word)
      }
    )

    println(wcAcc.value)*/


  }

  /**
   * 继承AccumulatorV2，定义范型
   * IN ： 累加器输入的数据类型
   * OUT： 累加器返回的数据类型
   */
  /* class MyAccumulator extends AccumulatorV2[String,mutable.Map[String,Long]]{

    private var wcMap = mutable.Map[String,Long]()

    override def isZero: Boolean = ???

    override def copy(): AccumulatorV2[String, mutable.Map[String, Long]] = ???

    override def reset(): Unit = ???

    //获取累加器需要计算的值
    override def add(word: String): Unit = {
      //val newCnt = wcMap.getOrElse(word,OL) + 1
      //wcMap.update(word,newCnt)
    }

    //Driver合并多个累加器
    override def merge(other: AccumulatorV2[String, mutable.Map[String, Long]]): Unit = {

    }


    //累加器结果

  }*/
}
