package com.gradeslate.gradeslate.backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Courses implements Serializable {
    private ArrayList<Course> courses;
    private float gpa;
    private String semester;

    public Courses(String semester) {
        this.gpa = 0.0f;
        this.courses = new ArrayList();
        this.semester = semester;
    }

    public void addCourse(String title, int time, int credHour) {
        this.courses.add(new Course(title, credHour));
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public Course getCourse(String title) {
        Iterator it = this.courses.iterator();
        while (it.hasNext()) {
            Course find = (Course) it.next();
            if (find.getTitle() == title) {
                return find;
            }
        }
        return null;
    }

    public void setName(String semester) {
        this.semester = semester;
    }

    public String getName() {
        return this.semester;
    }

    public float calcGPA() {
        float sumGPA = 0.0f;
        float count = (float) this.courses.size();
        Iterator it = this.courses.iterator();
        while (it.hasNext()) {
            Course calc = (Course) it.next();
            if (calc.letGrd() == 'A') {
                sumGPA += (float) (calc.getCredHour() * 4);
                count += 1.0f;
            } else if (calc.letGrd() == 'B') {
                sumGPA += (float) (calc.getCredHour() * 3);
                count += 1.0f;
            } else if (calc.letGrd() == 'C') {
                sumGPA += (float) (calc.getCredHour() * 2);
                count += 1.0f;
            } else if (calc.letGrd() == 'D') {
                sumGPA += (float) (calc.getCredHour() * 1);
                count += 1.0f;
            } else if (calc.letGrd() == 'F') {
                sumGPA += 0.0f;
                count += 1.0f;
            }
        }
        this.gpa = sumGPA / count;
        return this.gpa;
    }
}
