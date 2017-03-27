package com.gradeslate.gradeslate.backend;

import java.io.Serializable;

public class Student extends Person implements Serializable {
		Student() {
			super();
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
