package com.gradeslate.gradeslate.backend;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileSystem {
    private static FileSystem fileSystem;
    private static ArrayList<Courses> semesters;
    private Course course;
    private ArrayList<Course> courses;
    private Evaluation grade;
    private Grades grades;
    private Courses semester;

    private FileSystem() {
        semesters = new ArrayList();
        this.courses = new ArrayList();
    }

    public static FileSystem getInstance() {
        if (fileSystem == null) {
            synchronized (FileSystem.class) {
                if (fileSystem == null) {
                    fileSystem = new FileSystem();
                }
            }
        }
        return fileSystem;
    }

    public void addEvaluation(String name, int worth) {
        this.grades.addEval(name, (float) worth);
    }

    public Courses findSemester(String semester){
        for(Courses sem:semesters)
            if( sem.getName() == semester)
                return sem;
        return null;
    }



    public void setSemester(String semester){
        for(Courses find:semesters){
            if(find.getName()==semester){
                this.semester = find;
            }
        }
    }



    public void addSemester(String semester) {
        semesters.add(new Courses(semester));
    }

    public static ArrayList<Courses> getSemesters() {
        return semesters;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void addCourse(String course, int credHour) {
        this.courses.add(new Course(course, credHour));
    }

    public void setCourses(String semester){
        for(Courses sem:semesters)
            if( sem.getName() == semester)
                courses = sem.getCourses();
    }


    public void setCourse(String course){
        for(Course find:courses){
            if(find.getTitle()==course){
                this.course = find;
            }
        }
    }

    public Course getCourse() {
        return this.course;
    }

    public void setGrades(String course){
        for(Course cour:courses)
            if( cour.getTitle() == course)
                grades = cour.getGrades();
    }


    public Grades getGrades() {
        return this.grades;
    }

    public void setGrade(String type) {
        Iterator it = this.grades.getGrades().iterator();
        while (it.hasNext()) {
            Evaluation find = (Evaluation) it.next();
            if (find.getType() == type) {
                this.grade = find;
            }
        }
    }

    public Evaluation getGrade() {
        return this.grade;
    }

    public void writeSemesters(Context context) {
        try {
            InternalStorage.writeObject(context, "saved data", semesters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readSemesters(Context context) {
        String key = "saved data";
        ArrayList<Courses> listSemesters = new ArrayList();
        try {
            listSemesters = (ArrayList) InternalStorage.readObject(context, key);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        if (listSemesters != null) {
            semesters = listSemesters;
        }
    }
}
