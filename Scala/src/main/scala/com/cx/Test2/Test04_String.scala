package Test2

object Test04_String {
  def main(args: Array[String]): Unit = {
    val c : String = "pink"
    val b : String = "man"
    val a = c + b
    println(a)
    println(c * 3);

    printf("%s的后缀为%s",c,b)

    println()

    println(s"${c}的后缀为${b}")


    val num = 2.3456
    val number = 1
    println(f"${num}%2.2f .... $number%2.2f")

    val sql = s"""
       |select *
       |from
       |  user
       |where
       |  name = ${a}
       |""".stripMargin

    println(sql)
  }
}
