package com.gradeslate.gradeslate.backend;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private String phNum;
    private String stuNum;

    Student() {
        this.phNum = "Phone Number";
        this.stuNum = "Student Number";
    }

    public String getPhNum() {
        return this.phNum;
    }

    public String getStuNum() {
        return this.stuNum;
    }

    public void setPhNum(String phone) {
        this.phNum = phone;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }
}
