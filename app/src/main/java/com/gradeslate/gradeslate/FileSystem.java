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
    private Grades grades;
    private Courses semester;
    private Course course;

    private FileSystem(){
        semesters = new ArrayList();
        courses = new ArrayList();
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


    public void addEvaluation(String name, int worth){
        grades.addEval(name, worth);
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



    public void setGrades(String course){
        for(Course cour:courses)
            if( cour.getTitle() == course)
                grades = cour.getGrades();
    }

    public Grades getGrades() {
        return grades;
    }






}
