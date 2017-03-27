package com.gradeslate.gradeslate.backend;
import java.io.Serializable;
import java.util.ArrayList;

public class Courses implements Serializable{
	private ArrayList<Course>  courses;
	private float gpa = 0;
	private String semester;
	public Courses(String semester){
		this.courses = new ArrayList<Course>();
		this.semester = semester;
	}
	
	public void addCourse(String title, int time, int credHour){
		Course next = new Course(title, credHour);
		courses.add(next);
	}

	public ArrayList<Course> getCourses(){
        return courses;
    }

	public Course getCourse(String title){
		for(Course find:courses)
			if(find.getTitle() == title)
				return find;
		return null;
	}

	public void setName(String semester){
		this.semester = semester;
	}

	public String getName(){
		return semester;
	}
	
	
	public float calcGPA(){
		float sumGPA = 0;
		float count = courses.size();
		
		for(Course calc:courses){
			if(calc.letGrd() == 'A'){
				sumGPA += 4*calc.getCredHour();
				count++;
			}
			else if(calc.letGrd() == 'B'){
				sumGPA += 3*calc.getCredHour();
				count++;
			}
			else if(calc.letGrd() == 'C'){
				sumGPA += 2*calc.getCredHour();
				count++;
			}
			else if(calc.letGrd() == 'D'){
				sumGPA += 1*calc.getCredHour();
				count++;
			}
			else if(calc.letGrd() == 'F'){
				sumGPA += 0;
				count++;
			}

		}
		
		gpa = sumGPA/count;
		
		return gpa;
			
	}
}
