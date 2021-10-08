package com.rsw.entity;

public class Teacher {
    private String Tno;
    private String Password;
    private String Tname;
    private String Tsex;
    private Integer Tage;
    private String email;

    public Teacher(){}

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTsex() {
        return Tsex;
    }

    public void setTsex(String tsex) {
        Tsex = tsex;
    }

    public Integer getTage() {
        return Tage;
    }

    public void setTage(Integer tage) {
        Tage = tage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "Tno='" + Tno + '\'' +
                ", Password='" + Password + '\'' +
                ", Tname='" + Tname + '\'' +
                ", Tsex='" + Tsex + '\'' +
                ", Tage=" + Tage +
                ", email='" + email + '\'' +
                '}';
    }
}
