package com.shuangke;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

    @Test
    public void testFactoryBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComplexObject complexObject = context.getBean("myComplexObject", ComplexObject.class);
        System.out.println(complexObject);
    }
}
