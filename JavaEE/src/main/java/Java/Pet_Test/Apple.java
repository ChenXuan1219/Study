package Java.Pet_Test;

public class Apple extends Fruit{

    private String Type;

    public String getType() {
        return Type;
    }

    public Apple(String color, String address, String type) {
        super(color, address);
        Type = type;
    }


    public String show_Info() {
        return getFruit_Name()
                + "的颜色是：" + get_Info() + ","
                + "产地是：" + getAddress() +", "
                + "品种是" + getType()
                + "。";
    }
}
