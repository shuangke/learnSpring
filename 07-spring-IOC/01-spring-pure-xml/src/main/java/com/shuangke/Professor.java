package com.shuangke;

public class Professor {
    private String professorName;
    private String department;
    private double rating;

    public void Professor() {}

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Professor [professorName=" + professorName + ", department=" + department + ", rating=" + rating + "]";
    }
}
