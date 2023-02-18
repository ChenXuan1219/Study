package com.spring.Test_02;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("AnnotationInjectionServiceImpl")
public class AnnotationInjectionServiceImpl implements AnnotationInjectionService{

    @Resource(name = "AnnotationInjectionImpl")
    private AnnotationInjectionDaoImpl annotationInjectionDao;

    @Override
    public void save() {
        this.annotationInjectionDao.save();
        System.out.println("AnnotationInjectionServiceImpl save..");
    }
}
