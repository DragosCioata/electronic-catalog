package com.company;

public class Assistant extends User implements Element{
    Group group = new Group();

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Assistant(){

    }

}
