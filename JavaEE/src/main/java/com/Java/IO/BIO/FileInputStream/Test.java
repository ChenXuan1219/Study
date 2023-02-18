package com.Java.IO.BIO.FileInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * File_From 文件流
 * 字节流 FileInputStream  FileOutputStream 可以从文件系统中读取/写入 比如图像数据的原始字节流
 * 字符流 FileReader FileWriter
 *
 * read()方法返回字节的十进制数，或当到达文件尾部时返回-1，要实现当前开始读取的位置紧跟上一次结束读取的位置，猜测有一个类似指针的东西指向下一次读取的位置
 * read(byte b[])方法返回本次读取到的字节个数，且将读取到的字节存储到b中，或当到达文件尾部时返回-1
 */
public class Test {
    String src_from = "JavaEE/src/main/java/com/Java/IO/BIO/FileInputStream/File_From";
    String src_to = "JavaEE/src/main/java/com/Java/IO/BIO/FileInputStream/File_To";

    public void copyFile1(String src_from, String src_to) throws Exception{
        FileOutputStream outputStream = new FileOutputStream(src_to);
        FileInputStream inputStream = new FileInputStream(src_from);

        int read = inputStream.read();

        while (read != -1){
            outputStream.write(read);
            read = inputStream.read();
        }

        outputStream.close();
        inputStream.close();

    }

    public void copyFile2(String src_from, String src_to) throws Exception{

        FileOutputStream outputStream = new FileOutputStream(src_to);
        FileInputStream inputStream = new FileInputStream(src_from);

        byte[] bytes = new byte[2048];

        int read = inputStream.read(bytes);

        while (read != -1){
            System.out.println(read);
            outputStream.write(bytes ,0 ,read);
            read = inputStream.read(bytes);
        }

    }


    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.copyFile2(test.src_from,test.src_to);
    }
}
