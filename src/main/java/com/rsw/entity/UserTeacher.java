package com.rsw.entity;

public class UserTeacher {
    private String Uid;
    private String Teacher;
    private Integer index;
    private String Score;

    public UserTeacher(){}

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    @Override
    public String toString() {
        return "UserTeacher{" +
                "Uid='" + Uid + '\'' +
                ", Teacher='" + Teacher + '\'' +
                ", index=" + index +
                ", Score='" + Score + '\'' +
                '}';
    }
}
