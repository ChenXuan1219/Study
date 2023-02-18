package com.spring.Test_02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository(value = "UserDaoImpl" )
public class UserDaoImpl implements UserDo{

    @Value("chenxuan")
    private String name;

    @Value("123456")
    private int pwd;


    public String getName() {
        return name;
    }

    public int getPwd() {
        return pwd;
    }

    @Override
    public void login() {
        System.out.println("UserDaoImpl.login()");
    }
}
