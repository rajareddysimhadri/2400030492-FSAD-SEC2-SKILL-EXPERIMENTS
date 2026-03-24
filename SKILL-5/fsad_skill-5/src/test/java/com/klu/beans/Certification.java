package com.klu.beans;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id;
    private String name;
    private String dateOfCompletion;

    public Certification() {
        this.id = 1;
        this.name = "Spring Boot Certification";
        this.dateOfCompletion = "2026";
    }

    @Override
    public String toString() {
        return "Certification ID: " + id +
               ", Name: " + name +
               ", Date: " + dateOfCompletion;
    }
}