package com.gradeslate.gradeslate.backend;

import java.io.Serializable;

public class Professor extends Person implements Serializable {
		
		private String offLoc;
		private String offHour;
		private int offLen;
	
		
		Professor(){
			super();
		}
		
		public void setOffLoc(String location){
			this.offLoc = location;
		}
		
		public String getOffLoc(){
			return offLoc;
		}
		
		public void setOffHour(String offHour){
			this.offHour = offHour;
		}
		
		public String getOffHour(){
			return offHour;
		}
		
		public void setOffLen(int length){
			this.offLen = length;
		}
		
		public int getOffLen(){
			return offLen;
		}
		
		
}
