package Java.Pet_Test;

import java.util.Arrays;

abstract public class Pet {

    private int wight;

    private int age;

    private String Class_name = this.getClass().getName();

    public Pet(int wight, int age) {
        this.wight = wight;
        this.age = age;
    }

    public String Pet_name = Class_name.substring(Class_name.length() - 3);

    public String showInfo(){
        return Pet_name
                + "的体重有：" + getInfo_weight() + "kg ,"
                + "年龄为：" +  getInfo_age() + "岁。";

    }


    public float getInfo_weight(){
        return wight;
    }

    public int getInfo_age() {
        return age;
    }
}

