package com.Java.Socket;

import org.testng.annotations.Test;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Socket_Test {

    @Test
    public void Test_01() throws Exception{
        Socket socket = new Socket("43.142.54.68", 3305);
        socket.setSoTimeout(1500);
    }

    @Test
    public void Test_02() throws Exception{
        Socket socket = new Socket();
        InetSocketAddress address = new InetSocketAddress("43.142.54.68", 3305);
        socket.connect(address);
        socket.setSoTimeout(1500);
    }
}
