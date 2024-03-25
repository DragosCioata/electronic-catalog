package com.company;
import java.util.*;

public class Group extends Student implements Comparable<Student>{
    Assistant object;
    String ID;

    public Group(String ID, Assistant assistant, Comparator<Student> comp) {
        this.ID = ID;
        this.object = assistant;

    }

    public Group(String ID, Assistant assistant) {
        this.ID = ID;
        this.object = assistant;
    }

    public Group() {

    }


    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
