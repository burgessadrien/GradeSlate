package Project;

public class Weekday implements Time {

		private int time;
		private int day;
		
		Weekday(int time, int day){
			this.time = time;
			if((day <= 6)&&(day >= 0))
				this.day = day;
		}
		
		public void setDay(int day){
			if((day <= 6)&&(day >= 0))
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
}
