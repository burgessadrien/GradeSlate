package com.gradeslate.gradeslate;

public class Student extends Person{
		Student(String name) {
			super(name);
		}

		private String phNum;
		private String stuNum;
		
		public String getPhNum(){
			return phNum;
		}
		
		public String getStuNum(){
			return stuNum;
		}
		
		public void setPhNum(String phone){
			this.phNum = phone;
		}
		
		public void setStuNum(String stuNum){
			this.stuNum = stuNum;
		}
		
}
