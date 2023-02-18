package com.Java.IO.BIO.Serializable;

import java.io.*;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) throws Exception{
        User user = new User();
        user.setAge(5);
        user.setName("pinkMan");

        FileOutputStream outputStream = new FileOutputStream(new File("JavaEE/src/main/java/com/Java/IO/BIO/output.txt"));


        outputStream.write(new byte[]{12});


        System.out.println(new FileInputStream("JavaEE/src/main/java/com/Java/IO/BIO/output.txt").read());


    }
}
