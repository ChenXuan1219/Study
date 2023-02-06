package com.flink.sodata.parquet

import org.apache.avro.generic.{GenericData, GenericRecord}
import org.apache.avro.{Schema, SchemaBuilder}
import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.configuration.Configuration
import org.apache.flink.core.fs.Path
import org.apache.flink.formats.avro.typeutils.GenericRecordAvroTypeInfo
import org.apache.flink.formats.parquet.avro.ParquetAvroWriters
import org.apache.flink.streaming.api.CheckpointingMode
import org.apache.flink.streaming.api.datastream.{DataStreamSource, SingleOutputStreamOperator}
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.functions.sink.filesystem.{OutputFileConfig, StreamingFileSink}
import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.DateTimeBucketAssigner
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.OnCheckpointRollingPolicy
import org.apache.flink.streaming.api.functions.source.{RichSourceFunction, SourceFunction}

object CustomSource {
  case class Event(var distinct_id: String, var user_tag: String)
  def main(args: Array[String]): Unit ={

    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration)

    env.enableCheckpointing(60000, CheckpointingMode.EXACTLY_ONCE)
    env.getCheckpointConfig.setCheckpointStorage("file:///C:/tmp/ck")



    val streamSource: DataStreamSource[Event] = env.addSource(new RichSourceFunction[Event] {
      var run: Boolean = true

      override def run(ctx: SourceFunction.SourceContext[Event]): Unit = {
        while (run) {
          try {
            //Thread.sleep(100L)
            //ctx.collect(Event((Math.random() * 100000).asInstanceOf[Int], String.valueOf(Math.random() * 1000000000)))
            ctx.collect(Event("sodata_test_001","sodata_test_1012"))
            run = false
          } catch {
            case _:Exception => Thread.currentThread().interrupt()
          }

        }
      }

      override def cancel(): Unit = run = false
    })


    // 定义Schema
    val schema: Schema = SchemaBuilder.builder
      .record("event")
      .fields
      .requiredInt("id")
      .requiredString("name")
      .endRecord

    //构造支持列parquet格式的 sink算子
    val sink: StreamingFileSink[GenericRecord] = StreamingFileSink.forBulkFormat(new Path("/Users/chenxuan/Desktop/cx/IDEA_ Ultimate/Study/Flink/src/main/scala/com/flink/sodata/parquet") //输出目录
      , ParquetAvroWriters.forGenericRecord(schema))
      .withBucketAssigner(new DateTimeBucketAssigner[GenericRecord]("yyyy-MM-dd--HH"))
      .withRollingPolicy(OnCheckpointRollingPolicy.build[GenericRecord, String])
      .withOutputFileConfig(OutputFileConfig.builder.withPartPrefix("event")
        .withPartSuffix(".parquet")
        .build)
      .build
    implicit val typeInformation: TypeInformation[GenericRecord] = new GenericRecordAvroTypeInfo(schema)

    // 将自定义java bean的流，转成 上述sink算子中parquetWriter所需要的  GenericRecord流
    val dataSource: SingleOutputStreamOperator[GenericRecord] = streamSource.map((event: Event) => {
      val record = new GenericData.Record(schema)
      record.put("id", event.id)
      record.put("name", event.name)
      record
    }, new GenericRecordAvroTypeInfo(schema))

    // 输出数据
    dataSource.addSink(sink).setParallelism(1)
}
}