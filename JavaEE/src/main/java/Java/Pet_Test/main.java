package Java.Pet_Test;

public class main {
    public static void main(String[] args) {

        Cat cat = new Cat(10, 5);

        Dog dog = new Dog(5, 10);

        Apple apple = new Apple("red", "beijing","红富士");

        Banana banana = new Banana("yellow", "hainan");


        System.out.println(cat.showInfo());
        System.out.println(dog.showInfo());
        System.out.println(apple.show_Info());
        System.out.println(banana.show_Info());

        dog.beEatted(apple.getFruit_Name(),dog);





    }

}
