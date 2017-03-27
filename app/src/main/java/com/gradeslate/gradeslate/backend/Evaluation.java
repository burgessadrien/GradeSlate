package com.gradeslate.gradeslate.backend;

import java.io.Serializable;

public class Evaluation implements Serializable {
	private String evalType;
	private float grade;
	private float worth;
	private boolean grdEnt;
	private Team team;
	/*******
	 * 
	 * add tasks when ready
	 */

	public Evaluation(String type, float worth){
		this.evalType = type;
		this.worth = worth;
		team = new Team();
		grdEnt = false;
	}
	
	public void setEval(String type){
		evalType = type;
		
	}
	
	public Team getTeam(){
		return team;
	}
	
	public String getType(){
		return evalType;
	}
	
	public void addMember(String name){
		team.addMem(name);
	}
	
	public void setGrade(float grade){
		if((grade >=0) && (grade <= 100)) {
			this.grade = grade;
			grdEnt = true;
		}

	}

	public boolean entered(){
		return grdEnt;
	}
	
	public float getGrade(){
		return grade;
	}
	
	public float totalGrdPer(){
		float per = grade/100;
		float total = per*worth;
		return total;
	}
	
}
