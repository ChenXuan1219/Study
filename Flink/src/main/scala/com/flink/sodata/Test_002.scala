//package com.flink.sodata
//
//
//import org.apache.flink.streaming.api.TimeCharacteristic
//import org.apache.flink.streaming.api.functions.sink.filesystem.{BucketAssigner, StreamingFileSink}
//import org.apache.flink.streaming.api.scala._
//import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.{BasePathBucketAssigner, DateTimeBucketAssigner}
//import org.apache.flink.core.fs.Path
//import org.apache.flink.formats.parquet.avro.ParquetAvroWriters
//
//
//
//object Test_002 {
//  def main(args: Array[String]): Unit = {
//
//      val env = StreamExecutionEnvironment.getExecutionEnvironment
//      val hdfs_parquet_file_save_path = "Flink/src/main/scala/com/flink/sodata/tagdata/parquet"
//      env.enableCheckpointing(1000)
//      val port = 9999
//
//      val source: DataStream[String] = env.readTextFile("Flink/src/main/scala/com/flink/sodata/tagdata")
//
////
////            val wc: DataStream[WORD] = source
////              .flatMap(_.split("\\s"))
////              .filter(_ != null)
////              .filter(!"".equalsIgnoreCase(_))
////              .map(WORD(_, 1))
////              .keyBy("word")
////              .timeWindow(Time.seconds(3))
////              .sum("count")
//      //
//      //      /**
//      //       * ParquetAvroWriters 这种方式保存的文件，spark.read.parquet 可以直接读取
//      //       * 也可以 完整的写入到 hdfs文件中去
//      //       */
//            val sink_parquet: StreamingFileSink[Data] = StreamingFileSink
//              .forBulkFormat(new Path(hdfs_parquet_file_save_path), ParquetAvroWriters.forReflectRecord(classOf[Data]))
//              .withBucketAssigner(new DateTimeBucketAssigner())
//              .build()
//
//
//
//      env.execute("SocketSourceAvroparquetSink")
//    }
//  class CustomBucketAssigner extends BasePathBucketAssigner[Data] {
//    override def getBucketId(element: Data, context: BucketAssigner.Context): String = s"name=${element.count}"
//  }
//
//    case class Data(word: String, count: Int)
//
//}