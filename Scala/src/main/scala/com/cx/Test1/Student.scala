package Test1

class Student(name:String,age:Int){
  def printerInfo() : Unit = {
    println(name + " " + age + " " + S.school)

  }



}

object S{

  val school : String = "123"


}



//引入伴生对象
////与student同生死
//object Student{
//  val school:String = "PINK"
//
//  def main(args: Array[String]): Unit = {
//    val chen = new Student("chen", 12);
//    val xuan = new Student("xuan", 13)
//
//    chen.printerInfo()
//    xuan.printerInfo()
//  }
//}