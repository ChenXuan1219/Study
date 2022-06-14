
package com{
  //外层包中定义单例对象
  object Outer{
    var out : String = "out"
  }
  package cx{

    package scala{
      //内层包
      object Inner{
        def main(args: Array[String]): Unit = {
          println(Outer.out)
          Outer.out = "outIn"
          println(Outer.out)


        }
      }
    }
  }
}