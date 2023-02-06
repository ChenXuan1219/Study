package Java.Pet_Test;

import java.util.Arrays;

public class Fruit implements Eatable{

    private String color;

    private String address;


    public Fruit(String color, String address) {
        this.color = color;
        this.address = address;
    }

    public String getFruit_Name(){

        String Class_name = this.getClass().getName();

        return Class_name.substring(14);

    }

    public String show_Info() {
        return getFruit_Name()
                + "的颜色是：" + get_Info() + "，"
                + "产地是：" + getAddress()
                + "。";
    }

    public String get_Info() {
        return color;
    }

    public String getAddress() {
        return address;
    }



    @Override
    public void beEatted(String food, Pet pet) {

    }
}
