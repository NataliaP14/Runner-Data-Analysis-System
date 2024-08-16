
public class Time implements Comparable<Time> {
	private int hour;
	private int minutes;
	private double seconds;
	
	//regular constructor
	public Time(int hour, int minutes, double seconds) {
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
		
	}
	
	//constructor that initializes the time to 0
		public Time() {
			this.hour = 0;
			this.minutes = 0;
			this.seconds = 0;
		}
		
	
		@Override
	public int compareTo(Time o) {
		
		if (this.hour > o.hour) {
			return 1;
		}
		else if (this.hour < o.hour) {
			return -1;
		}
		else if (this.minutes > o.minutes) {
			return 1;
		}
		else if (this.minutes < o.minutes) {
			return -1;
		}
		else if (this.seconds > o.seconds) {
			return 1;
		}
		else if (this.seconds < o.seconds) {
			return -1;
		}
		else
			return 0;
	}
		
		public Time minus(Time o) {
			
		//declaring variable for mathematical operation
		int hour2 = this.hour - o.hour;
		int minutes2 = this.minutes - o.minutes;
		double seconds2 = this.seconds - o.seconds;
		
			return new Time(hour2, minutes2, seconds2);
			
		}
		
		public String toString() {
			if (hour < 0) {
				return hour * -1 + ":" + minutes + ":" + seconds * -1;
			}
			if (minutes < 0) {
				return hour + ":" + minutes * -1 + ":" + seconds;
			}
			if (seconds < 0) {
				return hour + ":" + minutes + ":" + seconds * -1;
			}
			else  {
			return hour + ":" + minutes + ":" + seconds;
			}
		}

		
}
	


	


