package Test4

object Test03_MulTable {
  def main(args: Array[String]): Unit = {
    for ( i <- 1 to 9 ) {
      for(j <- 1 to i) {
        print(s"$j * $i = ${i * j} \t")
      }
      println()
    }
  }

  println("=============")
  for (i <- 1 to 0 ; j <- 1 to i){
    print(s"$j * $i = ${i * j} \t")
    if (i == j) println()
  }

}
