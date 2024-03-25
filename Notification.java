package com.company;

public class Notification {
    Grade grade = new Grade();
    Student student = new Student();

    public Notification(Grade grade){
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Nota copilului:" + grade ;
    }
}
