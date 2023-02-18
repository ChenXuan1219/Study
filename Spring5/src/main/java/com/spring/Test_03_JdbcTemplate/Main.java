package com.spring.Test_03_JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {



    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config_04_jdbc.xml");

        UserDaoImpl userDaoImpl = (UserDaoImpl)applicationContext.getBean("UserDaoImpl");

        //System.out.println(userDaoImpl.addUser(new User(2, "chenziyue", 13)));

        System.out.println(userDaoImpl.selectUser());

    }
}

