package com.gradeslate.gradeslate.backend;

import com.gradeslate.gradeslate.BuildConfig;
import java.io.Serializable;

public class Evaluation implements Serializable {
    private String due;
    private String evalType;
    private float grade;
    private boolean grdEnt;
    private Team team;
    private float worth;

    public Evaluation(String type, float worth) {
        this.worth = 0;
        this.due = "";
        this.evalType = type;
        this.worth = worth;
        this.team = new Team();
        this.grdEnt = false;
    }

    public void setEval(String type) {
        this.evalType = type;
    }

    public Team getTeam() {
        return this.team;
    }

    public String getType() {
        return this.evalType;
    }

    public void addMember(String name) {
        this.team.addMem(name);
    }

    public void setGrade(float grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
            this.grdEnt = true;
        }
    }

    public void setDue(String date) {
        this.due = date;
    }

    public String getDue() {
        return this.due;
    }

    public void setWorth(float worth) {
        this.worth = worth;
    }

    public float getWorth() {
        return this.worth;
    }

    public boolean entered() {
        return this.grdEnt;
    }

    public float getGrade() {
        return this.grade;
    }

    public float totalGrdPer() {
        return (this.grade / 100) * this.worth;
    }
}
