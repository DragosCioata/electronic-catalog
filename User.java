package com.company;

public abstract class User {
    private String firstName, lastName;
    public User(){

    }
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String toString() {
        return firstName + " " + lastName;
    }
}

