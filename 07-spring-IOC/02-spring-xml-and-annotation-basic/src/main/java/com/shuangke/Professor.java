package com.shuangke;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Professor {
    // @Value("${property:defaultValue}") means that if the property is not found,
    // it will use the default value instead of throwing an exception
    @Value("${professor.name:defaultName}")
    private String professorName;
    @Value("${professor.department:defaultDepartment}")
    private String department;
    @Value("${professor.rating:0.0}")
    private double rating;

    public void Professor() {}

    @Override
    public String toString() {
        return "Professor [professorName=" + professorName + ", department=" + department + ", rating=" + rating + "]";
    }
}
