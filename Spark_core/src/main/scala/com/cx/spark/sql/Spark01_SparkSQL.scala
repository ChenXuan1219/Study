package com.cx.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/18 18:07
 */
object Spark01_SparkSQL {
  def main(args: Array[String]): Unit = {

    //val sparkSQL: SparkSession.Builder = SparkSession.builder().master("local[*]").appName("SparkSQL")

    val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("SparkSQL")

    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    //DataFrame

    val df: DataFrame = spark.read.json("datas/user.json")
    df.show


    //SQL
    df.createTempView("user")


    spark.sql("select * from user").show()
    spark.sql("select age from user").show()

    //DSL
    import spark.implicits._
    df.select("age","username").show()
    df.select($"age" + 1).show

    //DataSet
    /**
     * 特定泛型的DateSet
     */
    val seq: Seq[Int] = Seq(1, 2, 3, 4)
    val ds: Dataset[Int] = seq.toDS()
    println(ds.schema)
    ds.show()

    //RDD <=> DataFrame
    val rdd: RDD[(Int, String, Int)] = spark.sparkContext.makeRDD(List((1, "zx", 30), (2, "ls", 40)))
    val df1: DataFrame = rdd.toDF("id", "name", "age")
    df1.show()

    val ds1: Dataset[User] = df1.as[User]
    ds1.show()

    val df2: DataFrame = ds1.toDF()

    //DataFrame <=> Dataset

    //RDD <=> DataSet
    val ds2: Dataset[User] = rdd.map({
      case (id, name, age) => {
        User(id, name, age)
      }
    }).toDS()

  }
  case class User(id:Int, name:String, age:Int)
}
