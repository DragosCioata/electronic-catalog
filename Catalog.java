package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class Catalog implements Subject {
    ArrayList<Course> courses = new ArrayList<>();
    private static Catalog instance = null;
    ArrayList<Observer> observers = new ArrayList<>();
    private Catalog(){

    }

    public static Catalog getInstance(){
        if (instance == null){
            instance = new Catalog();
        }
        return instance;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void removeCourse(Course course){
        if(courses.contains(course)){
            courses.remove(course);
        }
        else {
            System.out.println("Nu exista");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for (int i = 0; i < observers.size(); i++) {
            Observer o = observers.get(i);
            if (grade.getStudent().getFather() == o) o.update(new Notification(grade));
            if (grade.getStudent().getMother() == o) o.update(new Notification(grade));

        }
    }

   public Course getCourse(String name){
       for (int i = 0; i < courses.size(); i++) {
           Course curs = courses.get(i);
           if (curs.name.equals(name)) {
               return curs;
           }
       }
        return null;
   }
}
