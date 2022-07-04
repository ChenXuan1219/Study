package Test2

object Test07_DataType {
  def main(args: Array[String]): Unit = {
    //Unit
    def m1() :Unit = {
      println("m1被执行")
    }

    val a = m1()
    println(a)



    def m2(n:Int) : Int={
      if (n == 0)
        throw new NullPointerException
      else
        n
    }

    println(m2(2))



  }



}
