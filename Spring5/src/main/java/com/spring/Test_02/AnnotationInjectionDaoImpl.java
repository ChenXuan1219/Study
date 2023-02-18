package com.spring.Test_02;


import org.springframework.stereotype.Repository;

@Repository("AnnotationInjectionImpl")
public class AnnotationInjectionDaoImpl implements AnnotationInjectionDao{
    @Override
    public void save() {
        System.out.println("AnnotationInjectionImpl save..");
    }

    public static void main(String[] args) {

    }
}
