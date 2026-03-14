package com.shuangke;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest2 {
    
    @Test
    public void testApproachOneOfGettingBean() {
        System.out.println("测试第一种获取 Bean 的方式：根据类型获取 Bean");
        // 1. 创建 Spring 的 IoC 容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 从容器中获取 Bean 对象
        Clazz clazzBean = context.getBean(Clazz.class);
        System.out.println(clazzBean);
    }

    @Test
    public void testApproachTwoOfGettingBean() {
        System.out.println("测试第二种获取 Bean 的方式：根据 Bean 的 id 获取 Bean");
        // 1. 创建 Spring 的 IoC 容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 从容器中获取 Bean 对象
        Clazz clazzBean = (Clazz) context.getBean("clazz");
        System.out.println(clazzBean);
    }

    @Test
    public void testApproachThreeOfGettingBean() {
        System.out.println("测试第三种获取 Bean 的方式：根据 Bean 的 id 和类型获取 Bean");
        // 1. 创建 Spring 的 IoC 容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 从容器中获取 Bean 对象
        Clazz clazzBean = context.getBean("clazz", Clazz.class);
        System.out.println(clazzBean);
    }
}
