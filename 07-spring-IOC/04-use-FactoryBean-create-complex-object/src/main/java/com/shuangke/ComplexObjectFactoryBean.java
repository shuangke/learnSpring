package com.shuangke;

import org.springframework.beans.factory.FactoryBean;

public class ComplexObjectFactoryBean implements FactoryBean<ComplexObject> {
    private String complexObjectName;
    @Override
    public ComplexObject getObject() throws Exception {
        // stimulate the process of creating a complex object
        System.out.println("run lots of code to create ComplexObject...");
        ComplexObject complexObject = new ComplexObject();
        complexObject.setObjectName(complexObjectName);
        return complexObject;
    }

    @Override
    public Class<?> getObjectType() {
        return ComplexObject.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    public void setComplexObjectName(String complexObjectName) {
        this.complexObjectName = complexObjectName;
    }
}
