package com.Java.IO.BIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test {

    public static void main(String[] args) throws Exception {

        FileOutputStream outputStream = new FileOutputStream("JavaEE/src/main/java/com/Java/IO/BIO/output.txt");

        outputStream.write(12);

    }
}
