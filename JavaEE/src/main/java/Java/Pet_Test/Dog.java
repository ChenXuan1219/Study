package Java.Pet_Test;

public class Dog extends Pet implements Eatable {

    private String cry = "wang!wang!wang!";

    public Dog(int wight, int age) {
        super(wight, age);
    }

    @Override
    public String  showInfo() {
        return Pet_name
                + "的体重有：" + getInfo_weight() + "kg, "
                + "年龄为：" +  getInfo_weight() + "岁, "
                + "叫声是 " + cry;
    }


    @Override
    public void beEatted(String food, Pet pet) {
        System.out.println(food + "被" + pet.Pet_name + "吃了");
    }
}
