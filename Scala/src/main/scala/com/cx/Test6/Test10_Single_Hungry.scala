package Test6

class Test10_Single_Hungry {
  def main(args: Array[String]): Unit = {

  }

}

class Single_Hungry private(){

}

object Single_Hungry{
  private var single_Hungry : Single_Hungry = _
  def newClass() : Single_Hungry = {
    if (single_Hungry == null) {
      single_Hungry = new Single_Hungry
    }
    single_Hungry
  }
}