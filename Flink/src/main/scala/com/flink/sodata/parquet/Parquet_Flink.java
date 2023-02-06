package com.flink.sodata.parquet;

          import org.apache.flink.api.common.restartstrategy.RestartStrategies;
          import org.apache.flink.api.common.serialization.SimpleStringEncoder;
          import org.apache.flink.api.common.typeinfo.Types;
          import org.apache.flink.api.java.tuple.Tuple2;
          import org.apache.flink.formats.parquet.avro.ParquetAvroWriters;
          import org.apache.flink.runtime.state.memory.MemoryStateBackend;
          import org.apache.flink.streaming.api.CheckpointingMode;
          import org.apache.flink.streaming.api.datastream.DataStreamSource;
          import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
          import org.apache.flink.streaming.api.environment.CheckpointConfig;
          import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
          import org.apache.flink.api.common.time.Time;
          import org.apache.flink.core.fs.Path;

          import java.io.File;
          import java.time.ZoneId;
          import java.util.concurrent.TimeUnit;

          import org.apache.flink.configuration.Configuration;
          import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
          import org.apache.flink.streaming.api.functions.sink.filesystem.bucketassigners.DateTimeBucketAssigner;

//socket
//        D:\2021_Flink_workspace\netcat-win32-1.11\netcat-1.11>
//        nc -l -p 6666

public class Parquet_Flink {
    
    public static void main(String[] args) throws Exception {
        class FlinkniuParquetPojo{String s1;int i1;

            public FlinkniuParquetPojo(String f0, Long f1) {
            }
        }
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());
        env.setParallelism(2);
        //step1
        env.enableCheckpointing(1000);

        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(2000L);
        env.getCheckpointConfig().setCheckpointTimeout(20000L);
        // env.getCheckpointConfig().setMaxConcurrentCheckpoints(1);
        env.getCheckpointConfig().enableExternalizedCheckpoints( CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);
        env.getCheckpointConfig().setFailOnCheckpointingErrors(true);
        //step2
        env.setRestartStrategy(
                RestartStrategies.fixedDelayRestart(
                        3,
                        Time.of( 0, TimeUnit.SECONDS)));

        MemoryStateBackend memoryStateBackend = new MemoryStateBackend(10 * 1024 * 1024, false);
        env.setStateBackend(memoryStateBackend);
        DateTimeBucketAssigner<FlinkniuParquetPojo>  BucketAssigner = new DateTimeBucketAssigner<>("yyyy\\MM\\dd\\HH", ZoneId.of("Asia/Shanghai"));
        DataStreamSource<String> socket = env.socketTextStream("localhost", 6666 );
        SingleOutputStreamOperator<FlinkniuParquetPojo> map = socket.map(f -> Tuple2.of(f, 1L))
                .returns(Types.TUPLE(Types.STRING, Types.LONG))
                .keyBy(0)
                .sum(1)
                .map(f -> new FlinkniuParquetPojo(f.f0, f.f1));

        StreamingFileSink<FlinkniuParquetPojo> sink = StreamingFileSink.forRowFormat(new Path("D:\\2021_Flink_workspace\\flinkniu\\src\\main\\java\\com\\flinkniu\\flink\\file")
                        , new SimpleStringEncoder<FlinkniuParquetPojo>("UTF-8"))
                .withBucketAssigner(BucketAssigner).build();

     /*   StreamingFileSink<FlinkniuParquetPojo> sink = StreamingFileSink.forBulkFormat(new Path("D:\\2021_Flink_workspace\\flinkniu\\src\\main\\java\\com\\flinkniu\\flink\\file")
                ,ParquetAvroWriters.forReflectRecord(FlinkniuParquetPojo.class))
                .withBucketAssigner(BucketAssigner).build();
*/

        map.addSink(sink);
        map.print();
        env.execute();
    }
}

