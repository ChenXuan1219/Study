package com.spring.Test_02;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("AnnotationInjectionController")
public class AnnotationInjectionController {

    @Resource(name = "AnnotationInjectionServiceImpl")
    private AnnotationInjectionServiceImpl annotationInjectionService;

    public void save(){
        this.annotationInjectionService.save();
        System.out.println("AnnotationInjectionController save..");
    }
}
