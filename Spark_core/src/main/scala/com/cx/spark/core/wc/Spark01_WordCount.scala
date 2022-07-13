package com.cx.spark.core.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/06/06 20:13
 */
object Spark01_WordCount {

  def main(args: Array[String]): Unit = {
    //Application

    //Spark框架

    //TODO 建立和Spark框架的连接

    //做一些基础的配置
      val wordCount = new SparkConf()
        .setMaster("local")
        .setAppName("wordCount")
    //建立连接
      val sparkContext = new SparkContext(wordCount)

    //TODO 执行业务操作
    //1.读取文件，获取一行一行的数据
      val lines: RDD[String] = sparkContext.textFile("Spark_core/src/main/data")

    //2.将数据拆分，形成当个单词(扁平化操作)
    val words: RDD[String] = lines.flatMap(_.split(" "))

    //3.根据单词分组(a,a,a) (b,b,b,b)
    val wordGroup: RDD[(String, Iterable[String])] = words.groupBy(words => words)

    //4.对分组后的数据转化(a,3),(b,4)
    val wordToCount = wordGroup.map {
      case  (word,list) => {
        (word,list.size)
      }
    }

    //5.将转换后的结果打印
    val array: Array[(String, Int)] = wordToCount.collect()
    array.foreach(println)

    //TODO 关闭连接
    sparkContext.stop()
  }
}
