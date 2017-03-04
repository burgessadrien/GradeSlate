package com.gradeslate.gradeslate.Backend;

public class Professor extends Person{
		
		private String offLoc;
		private int offHour;
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
		
		public void setOffHour(int offHour){
			this.offHour = offHour;
		}
		
		public int getOffHour(){
			return offHour;
		}
		
		public void setOffLen(int length){
			this.offLen = length;
		}
		
		public int getOffLen(){
			return offLen;
		}
		
		
}
