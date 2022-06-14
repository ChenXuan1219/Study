package Test4

object Test02_for {
  def main(args: Array[String]): Unit = {
    //1.范围遍历
    // to是一个方法调用 .省略 用" "替代

    for(i <- 1 to 10){
      printf("%d",i)
    }

    println("====================")
    for(i <- Range(1,10)){
      println(i + "range")
    }

    println("===========不包含10")
    for(i <- 1 until 10){
      println("new "+i)
    }


    println("========集合遍历")
    for(i <- Array(12,52,43)){
      println(i)
    }

    println("========循环守卫")
    for (i <- 1 to 10 if i != 5){
      println(i)
    }

    println("=======循环步长")
    for(i : Int <- 20 to 10 by -1)
      println(i)

    println("======反转遍历")
    for (i <- 10.0 to 1.0 by 0.5){
      println(i)
    }

    println("=========嵌套循环")
    for (i <- 1 to 3 ; j <- 1 to 3)
      println(i+" "+j)

    println("=======引入变量")
    for (i <- 1 to 10 ;j = i -1){
      println(s"$i : $j")
    }


    println("=======九层妖塔")
    for (i <- 1 to 9){
      var star = 2 * i - 1
      var space = 9 - i
      println(" " * space + "*" * star)

    }

    for (i <- 1 to 9;star = 2 * i - 1;space = 9 - i)
      println(" " * space + "*" * star)


    println("=========循环返回值")
    for(i <- 1 to 10){
      println(i)
    }
  }

}
