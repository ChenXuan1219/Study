package Test5

object Test07_Practice_Collection {
  def main(args: Array[String]): Unit = {
    val arr : Array[Int] = Array(12,45,75,98)

    def arrayOperations(arr: Array[Int], op: Int=>Int): Array[Int] = {
      for (elem <- arr) yield op(elem)
    }

    //加一
    def addOne(elem: Int): Int = {
      elem + 1
    }

    val newArray: Array[Int] = arrayOperations(arr,addOne _)

    println(newArray.mkString(","))

    val newArray1: Array[Int] = arrayOperations(arr,elem => elem * 2)
    val newArray2: Array[Int] = arrayOperations(arr,_ * 2)
    println(newArray1.mkString(","))
    println(newArray2.mkString(","))

  }

}
