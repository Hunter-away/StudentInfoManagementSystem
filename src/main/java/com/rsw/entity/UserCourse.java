package com.rsw.entity;

public class UserCourse {
    private String Uid;
    private String CName;
    private Integer index;

    public UserCourse(){}

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "Uid='" + Uid + '\'' +
                ", CName='" + CName + '\'' +
                ", index=" + index +
                '}';
    }
}
