package com.Protobuf;

import org.testng.annotations.Test;

public class AppTest {

    @Test
    public void test(){
        TestProto.LoginRequest.Builder login_builder = TestProto.LoginRequest.newBuilder();
        login_builder.setName("pinkMan");
        login_builder.setPwd("123456");

        TestProto.LoginRequest request = login_builder.build();

        System.out.println(request.getName());

        byte[] sendBuf = request.toByteArray();
        
    }
}
