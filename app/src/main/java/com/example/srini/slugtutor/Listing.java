package com.example.srini.slugtutor;

import java.io.Serializable;

public class Listing implements Serializable {

    private String id;
    private String name;
    private Course course;
    private String description;
    private String owner;

    public Listing() {}

    public Listing(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Listing(String id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Listing(String id, String name, String description, Course course) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = course;
    }

    public String toString() {
        return "id: " + id + ", name: " + name + ", course: " + course;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
