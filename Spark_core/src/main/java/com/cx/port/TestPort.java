package com.cx.port;

import java.io.IOException;
import java.net.*;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/07/19 15:48
 */
public class TestPort {

        private InetAddress ip;
        private int port;
        private DatagramSocket socket;

        public void SocketUDPClient(String ip, int port) throws UnknownHostException, SocketException {
            this.ip = InetAddress.getByName(ip);
            this.port = port;
    //创建一个UDP套接字，与本地任意一个未使用的UDP端口绑定
            socket = new DatagramSocket();
    //与本地一个固定的UDP端口绑定
    //socket=new DatagramSocket(9000);
        }

        public void send(String data){
            try {
                //先准备一个待发送的数据报
                byte[] outputData=data.getBytes();
                //构建一个数据报文。
                //构建一个数据报文。
                DatagramPacket outputPacket=new DatagramPacket(outputData, outputData.length, ip, port);
                //给EchoUDPServer发送数据报
                socket.send(outputPacket);  //给EchoUDPServer发送数据报
            } catch (IOException ex) { }
        }

        public void close(){
            if (socket != null)
                socket.close();//释放本地端口
        }

    public static void main(String[] args) throws SocketException, UnknownHostException {
        TestPort tp = new TestPort();
        tp.SocketUDPClient("47.100.170.101",9999);
        tp.send("123");

    }
}
