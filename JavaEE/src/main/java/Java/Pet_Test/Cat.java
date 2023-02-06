package Java.Pet_Test;


public class Cat extends Pet {

    private String cry = "miao~miao~miao";

    public Cat(int wight, int age) {
        super(wight, age);
    }

    @Override
    public String  showInfo() {
        return Pet_name
                + "的体重有：" + getInfo_weight() + "kg ,"
                + "年龄为：" +  getInfo_age() + "岁, "
                + "叫声是 " + cry;

    }

}
