package com.shuangke;

import com.shuangke.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest3 {
    
    @Test
    public void testApproachOneOfGettingBean() {
        System.out.println("测试第一种获取 Bean 的方式：根据类型获取 Bean");
        // 1. 创建 Spring 的 IoC 容器对象
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // 2. 从容器中获取 Bean 对象
        Clazz clazzBean = context.getBean(Clazz.class);
        System.out.println(clazzBean);
    }
}
