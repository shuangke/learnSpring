package com.shuangke;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Clazz {
    @Value("${clazz.code:defaultCode}")
    private String classCode;
    @Value("${clazz.name:defaultName}")
    private String className;
    @Autowired
    private Professor professor;

    //must have a no-arg constructor for spring to create the bean
    private void Clazz() {}

    @Override
    public String toString() {
        return "Clazz [classCode=" + classCode + ", className=" + className + ", professor=" + professor + "]";
    }
}
