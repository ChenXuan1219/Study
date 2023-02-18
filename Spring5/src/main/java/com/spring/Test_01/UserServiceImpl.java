package com.spring.Test_01;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserServiceImpl() {

    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }



    @Override
    public void login() {
        this.userDao.login();
        System.out.println("UserService login..");
    }
}
