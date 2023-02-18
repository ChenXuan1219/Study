package com.Java.Socket;
import org.testng.annotations.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {

    @Test
    public void Test01() throws Exception {


        ServerSocket serverSocket = new ServerSocket(8080);

        Socket accept = serverSocket.accept();

        System.out.println("一个客户连接成功,IP是： " + accept.getLocalAddress());

        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

        byte[] bytes = new byte[1024];

        int num = inputStream.read(bytes);

        while(num != -1){
            String string = new String(bytes, 0, num);
        }

        outputStream.write("欢迎".getBytes());

        accept.close();

        serverSocket.close();

    }

}
