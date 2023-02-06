package Java.Pet_Test;

public class Banana extends Fruit implements Eatable{

    private String Type;

    public String getType() {
        return Type;
    }

    public Banana(String color, String address) {
        super(color, address);
    }


}
