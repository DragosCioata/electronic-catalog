package com.company;

import java.util.ArrayList;

public class Parent extends User implements Observer{
    ArrayList<Notification> note = new ArrayList<>();
    public Parent(){

    }
    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void update(Notification notification) {
        note.add(notification);
    }


}
