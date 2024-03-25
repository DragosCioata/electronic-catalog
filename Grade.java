package com.company;

public class Grade implements Comparable, Cloneable{
    private double partialScore, examScore;
    private Student student;
    private String course;

    public Grade(){

    }
    public Grade(String course, Student student){
        this.course = course;
        this.student = student;
        partialScore = 0.0;
        examScore = 0.0;
    }

    public Double getPartialScore() {
        return partialScore;
    }

    public void setPartialScore(Double partialScore) {
        this.partialScore = partialScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getTotal(){
        return examScore + partialScore;
    }


    @Override
    public int compareTo(Object o) {
        Grade grade = new Grade();
        grade = (Grade) o;
        if(this.getTotal() < getTotal()) return 1;
            else return -1;
    }

}
