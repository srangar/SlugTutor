package com.example.srini.slugtutor;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Course implements Serializable {

    private String id;
    private String name;
    private String courseNum;
    private String professor;
    private String description;


    public Course() {}

    // TODO: Srini this constructor is now deprecated
    public Course(String courseNum, String professor, String description) {
        this.courseNum = courseNum;
        this.professor = professor;
        this.description = description;
    }

    public Course(String name, String courseNum, String professor, String description) {
        this.name = name;
        this.courseNum = courseNum;
        this.professor = professor;
        this.description = description;
    }

    public Course(String id, String name, String courseNum, String professor, String description) {
        this.id = id;
        this.name = name;
        this.courseNum = courseNum;
        this.professor = professor;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public String getDescription() {
        return description;
    }

    public String getProfessor() {
        return professor;
    }

    public String toString() {
        return "Course: " + courseNum + ", Professor: " + professor + ", Description: " + description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

}
