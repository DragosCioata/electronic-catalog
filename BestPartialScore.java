package com.company;

import java.util.Iterator;
import java.util.TreeSet;

public class BestPartialScore implements Strategy{
    @Override
    public Student getBestStudent(TreeSet<Grade> grades) {
        Grade student = grades.first();
        for(Iterator<Grade> iterator = grades.iterator(); iterator.hasNext();) {
            Grade grade = iterator.next();
            if (student.getPartialScore() < grade.getPartialScore()) student = grade;
        }
        return student.getStudent();
    }
}
