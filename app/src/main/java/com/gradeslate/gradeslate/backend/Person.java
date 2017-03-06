package com.gradeslate.gradeslate.backend;

public class Person {
	private String name = "Fred Tester";
	private String email;
	
	Person(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
}
