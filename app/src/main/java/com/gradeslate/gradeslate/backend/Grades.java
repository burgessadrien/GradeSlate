package com.gradeslate.gradeslate.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Grades implements Serializable {
    private float avgGrd;
    private float curGrd;
    private float gpa;
    private ArrayList<Evaluation> grades;
    private char letGrd;

    Grades() {
        this.grades = new ArrayList();
    }

    public void average() {
        float sum = 0;
        float num = 0;
        Iterator it = this.grades.iterator();
        while (it.hasNext()) {
            num += 1;
            sum += ((Evaluation) it.next()).getGrade();
        }
        this.avgGrd = sum / num;
    }

    public ArrayList<Evaluation> getGrades() {
        return this.grades;
    }

    public void letter() {
        average();
        if (this.avgGrd >= 80.0f && this.avgGrd <= 100.0f) {
            this.letGrd = 'A';
        } else if (this.avgGrd >= 65.0f && this.avgGrd <= 79.0f) {
            this.letGrd = 'B';
        } else if (this.avgGrd >= 55.0f && this.avgGrd <= 64.0f) {
            this.letGrd = 'C';
        } else if (this.avgGrd < 50.0f || this.avgGrd > 54.0f) {
            this.letGrd = 'F';
        } else {
            this.letGrd = 'D';
        }
    }

    public void curGrd() {
        Iterator it = this.grades.iterator();
        while (it.hasNext()) {
            this.curGrd += ((Evaluation) it.next()).totalGrdPer();
        }
    }

    public float getAvgGrds() {
        average();
        return this.avgGrd;
    }

    public float getCurGrd() {
        return this.curGrd;
    }

    public char getLetGrd() {
        return this.letGrd;
    }

    public void addEval(String type, float worth) {
        this.grades.add(new Evaluation(type, worth));
    }

    public ArrayList<Evaluation> getEvaluations() {
        return this.grades;
    }
}
