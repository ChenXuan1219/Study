package Test5

object Test08_Practice {
  def main(args: Array[String]): Unit = {

    //练习一
    val fun = (i: Int,s: String,c: Char) => {if(i == 0 && s == "" && c == '0')false else true}
    println(fun(0,"",0))

    println("==============")

    //练习二
    def func(num: Int) : String=>(Char=>Boolean) = {
      def f1(str: String) : Char=>Boolean = {
        def f2(ch: Char) : Boolean = {
          if(num == 0 && str == "" && ch == '0')false else true
        }
        f2
      }
      f1
    }

    println(func(0)("")('c'))
    println("=============")
    //简写
    def func1(num: Int) : String=>(Char=>Boolean) = {
      str => ch => if(num == 0 && str == "" && ch == '0')false else true
    }
    //柯里化
    def func2(num: Int)(str: String)(ch: Char) = {
      if(num == 0 && str == "" && ch == '0')false else true
    }
  }

}
