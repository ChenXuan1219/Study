package Test6

object Test09_Single {
  def main(args: Array[String]): Unit = {
    val single_class = new Single_class("cx",23)
    single_class.printInfo()



    val single_class2 = Single_class2.newClass("lyr",22)
    single_class2.printInfo()
  }

}


class Single_class(val name:String,val age:Int){
  def printInfo(){
  println (s"name = ${name},age = ${age},school = ${Single_class.school}"
  )
  }
}

object Single_class{
  val school:String = "pink"
}


class Single_class2 private (val name:String,val age:Int){
  def printInfo(){
    println (s"name = ${name},age = ${age},school = ${Single_class.school}"
    )
  }
}

object Single_class2{
  val school:String = "pink"
  //定义类的对象实例的工厂方法
  def newClass(name:String,age:Int): Single_class2 = {
     new Single_class2(name,age)
  }
}