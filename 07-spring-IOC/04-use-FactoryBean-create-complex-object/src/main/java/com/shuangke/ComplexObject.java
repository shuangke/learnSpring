package com.shuangke;

public class ComplexObject {
    private String objectName;
    public void ComplexObject() {}

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "objectName='" + objectName + '\'' +
                '}';
    }
}
