package com.gradeslate.gradeslate;
import java.util.ArrayList;

public class Team {
	private ArrayList<Student> members = new ArrayList<Student>();
	
	Team(){}
	
	public void addMem(String name){
		Student stu = new Student(name); //fuck stu 
		members.add(stu);
	}
	
	public void remMem(String name){
		int count = 0;
		for(Student student:members){
			if(student.getName() == name)
				members.remove(count);
			else
				count++;
		}
	}
	
	public String getMem(String name){
		for(Student student:members){
			if(student.getName() == name)
				return student.getName();
		}
		
		return "Student is not part of this team";
			
	}
	
	
}
