package com.spring.Test_01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config01.xml");


        UserImpl userImpl = (UserImpl) applicationContext.getBean("UserImpl");
        UserImpl userImpl1 = (UserImpl) applicationContext.getBean("UserImpl");


        UserServiceImpl userService = (UserServiceImpl)applicationContext.getBean("UserServiceImpl");
        UserServiceImpl userService1 = (UserServiceImpl)applicationContext.getBean("UserServiceImpl");

        System.out.println(userImpl);
        System.out.println(userImpl1);


    }
}
