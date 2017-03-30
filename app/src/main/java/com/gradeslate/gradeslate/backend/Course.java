package com.gradeslate.gradeslate.backend;

import java.io.Serializable;
import java.util.Iterator;

public class Course implements Serializable {
    private int credHour;
    private Grades grades;
    private Bookbag knapsack;
    private Professor prof;
    private String title;

    public Course(String title, int credHour) {
        this.knapsack = new Bookbag();
        this.grades = new Grades();
        this.credHour = 0;
        this.title = title;
        this.credHour = credHour;
        this.prof = new Professor();
    }

    public Professor getProf() {
        return this.prof;
    }

    public Grades getGrades() {
        return this.grades;
    }

    public Bookbag getBag() {
        return this.knapsack;
    }

    public String getTitle() {
        return this.title;
    }

    public float desGrd(float des) {
        int numEntGrd = 0;
        int numGrd = 0;
        float curVal = 0;
        float check = 0;
        float result = des;
        if(grades.getGrades().isEmpty()==true){
            result = des;
            return result;
        }
        Iterator it = this.grades.getEvaluations().iterator();
        while (it.hasNext()) {
            Evaluation eval = (Evaluation) it.next();
            if (eval.entered()) {
                numEntGrd++;
                curVal += eval.getGrade();
                check += eval.totalGrdPer();
            }
            numGrd++;
        }
        float max = des * ((float) numGrd);
        if (des - check <= 0) {
            result = 0;
            return result;
        }
        result=(max - curVal) / ((float) (numGrd - numEntGrd));
        return result;
    }

    public char letGrd() {
        return this.grades.getLetGrd();
    }

    public int getCredHour() {
        return this.credHour;
    }
}
