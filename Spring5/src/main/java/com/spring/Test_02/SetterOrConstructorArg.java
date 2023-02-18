package com.spring.Test_02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SetterOrConstructorArg {
    private String name;
    private int age;
    private List list;

    public SetterOrConstructorArg() {
    }

    public SetterOrConstructorArg(String name, int age, List list) {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Test_SetterInjection{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config02.xml");

        SetterOrConstructorArg ConstructorArg = (SetterOrConstructorArg)applicationContext.getBean("ConstructorArg");

        SetterOrConstructorArg Setter = (SetterOrConstructorArg)applicationContext.getBean("Setter");

        System.out.println(ConstructorArg);
        System.out.println(Setter);
    }
}
