package com.codeup.blogapp.data;

public class Person {

    private String name;
    private String occupation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Person(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }
}
