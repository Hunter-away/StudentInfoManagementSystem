package com.rsw.entity;

import java.util.List;

public class CourseInfo {
    private List<String> names;
    private List<Integer> LessonPeriod;

    public CourseInfo(){}

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Integer> getLessonPeriod() {
        return LessonPeriod;
    }

    public void setLessonPeriod(List<Integer> lessonPeriod) {
        LessonPeriod = lessonPeriod;
    }
}
