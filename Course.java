package com.company;

import java.util.*;

public abstract class Course {
    String name;
    Teacher titular;
    Strategy strategy;
    ArrayList<Assistant> assistants = new ArrayList<>();
    ArrayList<Assistant> group = new ArrayList<>();
    ArrayList<Assistant> student = new ArrayList<>();
    TreeSet<Grade> grades = new TreeSet<>();
    HashMap<String,Course> dictionay = new HashMap<String, Course>();
    Integer credit;

    public Course(){

    }
    public Course(CourseBuilder course){
        this.name = course.name;
        this.student = course.student;
        this.group = course.group;
        this.titular = course.titular;
        this.strategy = course.strategy;
        this.assistants = course.assistants;
        this.grades = course.grades;
        this.dictionay = course.dictionary;
        this.credit = course.credit;
    }

    static class CourseBuilder{
        private String name;
        private Teacher titular;
        private Strategy strategy;
        private ArrayList<Assistant> assistants = new ArrayList<>();
        private ArrayList<Assistant> student = new ArrayList<>();
        private ArrayList<Assistant> group = new ArrayList<>();
        private TreeSet<Grade> grades = new TreeSet<>();
        private HashMap<String,Course> dictionary = new HashMap<String, Course>();
        private Integer credit;

        public CourseBuilder(String nume){
            name = nume;
        }

        public CourseBuilder assistant(Assistant assistant){
            this.assistants.add(assistant);
            return this;
        }


        public CourseBuilder teacher(Teacher teacher){
            this.titular = teacher;
            return this;
        }

        public CourseBuilder grade(Grade grade){
            this.grades.add(grade);
            return this;
        }

        public CourseBuilder strategy(Strategy strategy){
            this.strategy = strategy;
            return this;
        }

        public Course build(){
            return new Course(this) {

                public ArrayList<Student> getGraduatedStudents() {
                    return null;
                }
            };
        }
    }

    // lipsa metode clasa course

    public void addAssistant(String ID, Assistant assistant){
        if (!assistants.contains(assistant))
            assistants.add(assistant);
    }

    public void addStudent(String ID, Student student){

    }

    public void addGroup(Group group){

    }

    public void addGroup(String ID, Assistant assistant){

    }

    public void addGroup(String ID, Assistant assist, Comparator<Student> comp){

    }

    //public Grade getGrade(Student student){

    //}

    public void addGrade(Grade grade){
        this.grades.add(grade);
    }

   // public ArrayList<Student> getAllStudents(){

   // }

    //public HashMap<Student, Grade> gettAllStudentGrades(){

    //}

    //public abstract ArrayList<Student> getGraduatedStudents();

    public Student getBestStudent(){
        return strategy.getBestStudent(grades);
    }

}
