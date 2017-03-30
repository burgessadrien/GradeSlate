package com.gradeslate.gradeslate.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Grades implements Serializable {
    private float avgGrd;
    private float curGrd;
    private ArrayList<Evaluation> grades;
    private char letGrd;

    Grades() {
        this.grades = new ArrayList();
        this.avgGrd = 100;
        this.curGrd = 0;
        this.letGrd = 'A';
    }

    public void average() {
        float sum = 0;
        float num = 0;
        for(Evaluation eval:grades){
            if(eval.entered()==true) {
                num += 1;
                sum += eval.getGrade();
            }
        }
        if(num >0)
            this.avgGrd = sum / num;
        else{
            this.avgGrd = 0;
        }

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
            this.letGrd = 'D';
        } else {
            this.letGrd = 'F';
        }
    }

    public void curGrd() {
        float sum = 0;
        for(Evaluation eval:grades){
            sum+= eval.getGrade()*eval.getWorth()/100;
        }
        this.curGrd = sum;
    }

    public float getAvgGrds() {
        average();
        return this.avgGrd;
    }

    public float getCurGrd() {
        curGrd();
        return this.curGrd;
    }

    public char getLetGrd() {
        average();
        letter();
        return this.letGrd;
    }

    public void addEval(String type, float worth) {
        this.grades.add(new Evaluation(type, worth));
    }

    public ArrayList<Evaluation> getEvaluations() {
        return this.grades;
    }
}
