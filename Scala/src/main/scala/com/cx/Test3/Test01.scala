package Test3

object Test01 {
  def main(args: Array[String]): Unit = {
    val str1 : String = "chen"
    val str2 : String = new String("chen");
    println(str1 == str2)


    println("=====================")
    val a : Char = 'a';
    val b : Char = 'b';

    val c : Char = 1.toChar
    val d : Char = 2.toChar
    println(c & d)
  }
}
