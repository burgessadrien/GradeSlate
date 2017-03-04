package com.gradeslate.gradeslate.Backend;

public class Person {
	private String name;
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
