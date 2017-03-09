package com.gradeslate.gradeslate;

import com.gradeslate.gradeslate.backend.Course;
import com.gradeslate.gradeslate.backend.Courses;
import com.gradeslate.gradeslate.backend.Evaluation;
import com.gradeslate.gradeslate.backend.Evaluations;
import com.gradeslate.gradeslate.backend.Grades;

import java.util.ArrayList;

/**
 * Created by adrien on 07/03/17.
 *
 * referenced: https://www.tutorialspoint.com/java/java_using_singleton.htm
 */


/*
Singleton used to hold data about courses and other information for the user so that it
can be used by the variuous activities
 */

public class FileSystem {

    private static FileSystem fileSystem;
    private static ArrayList<Courses> semesters;
    private ArrayList<Course> courses;
    private ArrayList<Evaluation> evals;
    private Grades grades;
    private String semester;
    private String course;
    private String grade;

    private FileSystem(){
        semesters = new ArrayList();
        courses = new ArrayList();
        evals = new ArrayList();
    }

    //Static instance method

    public static FileSystem getInstance(){
        if(fileSystem == null){
            synchronized (FileSystem.class){
                if(fileSystem == null){
                    fileSystem = new FileSystem();
                }
            }
        }
        return fileSystem;
    }

    public Courses findSemester(String semster){
        for(Courses sem:semesters)
            if( sem.getName() == semester)
                return sem;
        return null;
    }

    public void addSemester(String semester){
        Courses next =  new Courses(semester);
        semesters.add(next);
    }

    public static ArrayList<Courses> getSemesters(){
        return semesters;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(String course, int credHour){
        courses.add(new Course(course, credHour));
    }
    public Course getCourse(String course){
        for(Course send:courses)
            if(send.getTitle()==course)
                return send;
        return null;
    }

    public Evaluation getEval(String name){
        for(Evaluation send:evals)
            if(send.getType()==name)
                return send;
        return null;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setCourses(String semester){
        for(Courses sem:semesters)
            if( sem.getName() == semester)
                courses = sem.getCourses();
    }

    public void getGrades(String course){
        for(Course cour:courses)
            if( cour.getTitle() == course)
                grades = cour.getGrades();
    }

    public void getEvals(){
       evals = grades.getGrades();
    }





}
