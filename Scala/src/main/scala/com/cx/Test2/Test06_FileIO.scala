package Test2

import java.io.{File, PrintWriter}
import scala.io.Source

object Test06_FileIO {
  def main(args: Array[String]): Unit = {
    //1.从文件中读取数据
    Source.fromFile("src/main/scala/README").foreach(print)

    //
    val writer = new PrintWriter(new File("src/main/scala/Test2/Test1.txt"))
    writer.write("chen")
    writer.close()
  }
}
