package com.spring.Test_02;

import org.springframework.stereotype.Repository;

@Repository(value = "SenderDaoImpl")
public class SenderDaoImpl implements SenderDao{

    private String URL;

    private int PORT;

    @Override
    public void login() {
        System.out.println("SenderDaoImpl.login()");
    }
}
