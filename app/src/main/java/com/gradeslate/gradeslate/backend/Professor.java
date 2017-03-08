package com.gradeslate.gradeslate.backend;

public class Professor extends Person{
		
		private String offLoc;
		private String offHour;
		private int offLen;
	
		
		Professor(String name){
			super(name);
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
