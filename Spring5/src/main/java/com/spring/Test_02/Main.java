package com.spring.Test_02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config03.xml");

        AnnotationInjectionController annotationInjectionController = (AnnotationInjectionController) applicationContext.getBean("AnnotationInjectionController");

        annotationInjectionController.save();
    }
}
