package com.spring.Test_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@org.springframework.stereotype.Controller("Controller")
public class Controller {

    @Autowired
    @Qualifier(value = "UserDaoImpl")
    private UserDaoImpl userDao;

    @Resource(name = "SenderDaoImpl")
    private SenderDaoImpl senderDao;

    public void login(){
        userDao.login();
        System.out.println("name: " + userDao.getName());
        senderDao.login();

        System.out.println("Controller.login()");
    }

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config03.xml");

        Controller controller = (Controller)applicationContext.getBean("Controller");

        controller.login();



    }
}
