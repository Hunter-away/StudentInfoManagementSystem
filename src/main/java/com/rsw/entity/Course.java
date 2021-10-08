package com.rsw.entity;

public class Course {
    private String ID;
    private String Name;
    private Double Credit;
    private String Teacher;
    private Integer LessonPeriod;

    public Course(){}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getCredit() {
        return Credit;
    }

    public void setCredit(Double credit) {
        Credit = credit;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public Integer getLessonPeriod() {
        return LessonPeriod;
    }

    public void setLessonPeriod(Integer lessonPeriod) {
        LessonPeriod = lessonPeriod;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Credit=" + Credit +
                ", Teacher='" + Teacher + '\'' +
                ", LessonPeriod=" + LessonPeriod +
                '}';
    }
}
