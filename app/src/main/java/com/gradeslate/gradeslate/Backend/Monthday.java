package Project;

public class Monthday implements Time {

	private int time;
	private int day;
	private int month;
	
	Monthday(int time, int day, int month){
		this.time = time;
		this.day = day;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	
	
	public void setTime(int time){
		this.time = time;
	}
	
	public int getTime(){
		return time;
	}
	
	public int getDay(){
		return day;
	}
}
