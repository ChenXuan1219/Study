package com.Java.Socket;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client_Socket {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 8080);

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();


        //发送数据
        FileInputStream fileOutputStream = new FileInputStream("JavaEE/src/main/java/com/Java/Socket/README");

        byte[] bytes = new byte[1024];

        int read = fileOutputStream.read(bytes);

        while (read != -1) {

            outputStream.write(bytes);

            read = fileOutputStream.read(bytes);

        }


        //接受数据

        byte[] receive = new byte[1024];

        int len;

        while ((len = inputStream.read(receive)) != -1){
            System.out.println(new String(receive,0,len));
        }

        socket.close();
    }
}
