package com.company;

public class UserFactory{

    public User getUser(User user){
        if(user instanceof Student) {
            return new Student();
        }
        if(user instanceof Teacher){
            return new Teacher();
        }
        if(user instanceof Assistant){
            return new Assistant();
        }
        if(user instanceof Parent){
            return new Parent();
        }

        return null;
    }
}

