package com.cx.spark.core.rdd.operator.transform

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/05 11:32
 */
object Test {
  def main(args: Array[String]): Unit = {

    //map(x => (x, null)).reduceByKey((x, _) => x, numPartitions).map(_._1)
    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("Operator"))
    sc.makeRDD(List(
      ("a",1),("a",2),("a",3),("a",4),("a",5),("a",6)
    ),2)
      .aggregateByKey(0)(
        (x,y) => math.max(x,y),
        (x,y) => x + y
      )
      .collect()
      .foreach(println)


    sc.stop()

  }
}
