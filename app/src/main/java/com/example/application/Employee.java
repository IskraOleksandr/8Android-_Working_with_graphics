package com.example.application;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String proffesion;
    private int age;
    private String photo;


    public Employee(String name, String proffesion, int age, String photo) {
        this.name = name;
        this.proffesion = proffesion;
        this.age = age;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getProffesion() {
        return proffesion;
    }

    public int getAge() {
        return age;
    }

    public String getPhoto() {
        return photo;
    }
}
