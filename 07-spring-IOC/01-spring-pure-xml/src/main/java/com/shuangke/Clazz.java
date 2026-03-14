package com.shuangke;

public class Clazz {
    private String classCode;
    private String className;
    private Professor professor;

    //must have a no-arg constructor for spring to create the bean
    private void Clazz() {}

    //setter
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Clazz [classCode=" + classCode + ", className=" + className + ", professor=" + professor + "]";
    }
}
