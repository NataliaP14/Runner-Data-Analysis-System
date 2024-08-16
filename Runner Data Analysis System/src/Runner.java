public class Runner implements Comparable<Runner> {
	private String name;
	private String country;
	private Time startingTime;
	private Time endingTime;
	private Time raceTime;
	

		//constructor for the variables
		public Runner(String name, String country, Time startingTime, Time endingTime, Time raceTime) {
			
			this.name = name;
			this.country = country;
			try {
			this.startingTime = startingTime;
			this.endingTime = endingTime;
			this.raceTime = endingTime.minus(startingTime);
			} catch (NullPointerException e) {
				
				}
		}

		//returns the race time
		public Time raceTime() {
			return raceTime;
		}
		
		//compares the racetimes to find the medalists
		public int compareTo(Runner o) {
			return this.raceTime.compareTo(o.raceTime());
			
		}
		//printing out the data
		public String toString() {
			return "Name: " + name + "\n" +
			"Country: " + country + "\n" +
			"Start Time: " + startingTime + "\n" +
			"End Time: " + endingTime + "\n" + 
			"Race Time: " + raceTime + "\n";
		
		}
	}
