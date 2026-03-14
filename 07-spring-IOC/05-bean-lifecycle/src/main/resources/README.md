# Bean lifecycle
1. Loading bean definitions (applicationContext.xml files)


2. 根据BeanDefinition里面的<bean>标签创建BeanDefinition对象，存在一个ConcurrentMap里面：
   - ConcurrentMap<beanId, BeanDefinition> beanDefinitionMap:
   ``` 
   BeanDefinition {
         String id;
         String className;
         String scope;
         String initMethod;
         String destroyMethod;
         List<Property> properties; // Property { String name; String value; }
         // 其他属性...
     }
   ```

3. <span style="color:red; font-weight:bold;">Optional:修改BeanDefinition objects(批量修改菜谱)：</span>
   - 遍历beanDefinitionMap，找到scope为singleton的BeanDefinition
   - 对于每个singleton BeanDefinition，执行步骤


4. 实例化bean但先不给属性赋值（singleton scope）：
   - 根据BeanDefinition创建bean实例
   - 将bean实例放入一个ConcurrentMap里面：
     - ConcurrentMap<beanId, Object> singletonObjects

&nbsp;
5. 给bean实例属性赋值（依赖注入）：
   - 根据BeanDefinition中的属性信息，使用反射给bean实例的属性赋值
   - 如果属性是引用类型（ref），则先获取依赖的bean实例，再赋值
   
&nbsp;

**--------------------------------bean 对象实例化结束了------------------------**
   
&nbsp;

6. <span style="color:red; font-weight:bold;"> Optional:before bean init方法调用前修改bean实例化对象 （可以批量修改做好的菜) </span>
  - 调用BeanPostProcessor的postProcessBeforeInitialization方法：
  - 遍历所有注册的BeanPostProcessor，调用postProcessBeforeInitialization方法


7. <span style="color: blueviolet; font-weight:bold;"> Optional: 调用bean的初始化方法（init-method）：</span>
  - 如果BeanDefinition中配置了init-method，则使用反射调用该方法


8. <span style="color:red; font-weight:bold;"> Optional:after bean init方法调用后修改bean实例化对象 （可以批量修改做好的菜）</span>
  - 调用BeanPostProcessor的postProcessAfterInitialization方法：   
  - 遍历所有注册的BeanPostProcessor，调用postProcessAfterInitialization方法

 
9. Bean就绪，可以被应用程序使用了


10. <span style="color: blueviolet; font-weight:bold;"> Optional: 调用bean的销毁方法(destroy-method) </span>
- 当应用程序关闭时，调用bean的销毁方法（destroy-method)
- 如果BeanDefinition中配置了destroy-method，则使用反射调用该方法