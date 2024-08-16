import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunnerClient {
	public static void main(String[] args ) throws FileNotFoundException  {
			//file for runners
			File input = new File("runners.dat");
			
			//ArrayList for runners and errors
			ArrayList<Runner> runners = new ArrayList<Runner>();
			ArrayList<String> errors = new ArrayList<String>();	
			
			//scanner
			Scanner scanner = new Scanner(input);
			
			//declaring variables
			int lineNum = 0;
			String name = " "; 
			String country = " ";
			Time startTimes = new Time();
			Time endTimes = new Time();
			
			
			//reading the data and adding it into the arraylist using a switch
			while (scanner.hasNextLine()) {
				lineNum++;
				
				switch (lineNum % 4) {
					//Name
					case 1:
						name = scanner.nextLine();
						break;
					//Country
					case 2:
						country = scanner.nextLine();
						break;
					//Start Time
					case 3:
						try {
						 startTimes = Parse(scanner.nextLine());
						 }
						catch(InputMismatchException e){	
							 errors.add("Error! Line: " + lineNum + " mismatch error for " + name + ", skipping to next runner");
						}
						break;
					//End Time
					case 0:
						try {
							endTimes = Parse(scanner.nextLine());
							Runner runner = new Runner(name, country, startTimes, endTimes, null);
							runners.add(runner);
							}
						catch(InputMismatchException e) {
							errors.add("Error! Line: " + lineNum + " mismatch error for " + name + ", skipping to next runner");
						}
						break;
				}
				
			}
			
	scanner.close();
	//declaring variables and creating methods for winners
		Runner goldWinner = Medalists1(runners);
		Runner silverWinner = Medalists2(runners);
		Runner bronzeWinner = Medalists3(runners);
	//printing the results to results.dat
	PrintWriter results = new PrintWriter("results.dat");
	results.println("RUNNERS");
	System.out.println("RUNNERS");
	for (Runner runner: runners) {
	 
		//printing runners to console
		System.out.println(runner);
		results.println(runner);
	}
	
	System.out.println("WINNERS");
	results.println("WINNERS");
	//printing out the medalist results
	results.println("Gold Winner");
	results.println(goldWinner);
	System.out.println("Gold Winner");
	System.out.println(goldWinner);
	
	results.println("Silver Winner");
	results.println(silverWinner);
	System.out.println("Silver Winner");
	System.out.println(silverWinner);
	
	results.println("Bronze Winner");
	results.println(bronzeWinner);
	System.out.println("Bronze Winner");
	System.out.println(bronzeWinner);
	
	
	results.close();

	//printing errors in errors.dat
	PrintWriter errorResults = new PrintWriter("errors.dat"); 
	
	System.out.println("ERRORS");
	for (String error: errors) {
		errorResults.println(error);
		System.out.println(error);
		
	}
	System.out.println("Total number of errors: " + errors.size());
	errorResults.println("Total number of errors: " + errors.size());
	errorResults.close();
	
	
	}
	
	//method 1 for gold winner
	private static Runner Medalists1(ArrayList<Runner> runners) {
		if (runners.isEmpty()) {
			return null;
		} else {
			//setting the first place runner to index 0 initially
		Runner first = runners.get(0);
		for (Runner runner : runners)
			 if (runner.compareTo(first) == -1) {
		 		first = runner;
		 		}
		
	return first;
		}
	}
	//method 2 for silver winner
	private static Runner Medalists2(ArrayList<Runner> runners) {
		if (runners.isEmpty()) {
			return null;
		} else {
		//setting first and second place runners to index 0
		Runner first = runners.get(0);
		Runner second = null;
		
		 for (Runner runner : runners)
			 if (runner.compareTo(first) == -1) {
				 second = first;
		 		first = runner;
		 		}
	return second;
		}
	}
	private static Runner Medalists3(ArrayList<Runner> runners) {
		if (runners.isEmpty()) {
			return null;
		}
		//setting first, second, and third to index 0 and null
		Runner first = runners.get(0);
		Runner second = null;
		Runner third = null;
		 for (Runner runner : runners)
			  if (runner.compareTo(first) == -1) {
				 third = second;
		 		second = first;
		 		first = runner;
		 		
			 }
			  	else if (second == null || runner.compareTo(second) == -1) {
		 			third = second;
		 			second = runner;
		 			
		 		}
			  		else if (third == null || runner.compareTo(third) == -1) {
		 			third = runner;
		 		}
		return third; 
		 }

//parsing the hours,min,and seconds from the input file
	 static Time Parse(String nextLine) {
		// TODO Auto-generated method stub
			try {
				
				String[] split = nextLine.split(" ");
				int hour = Integer.parseInt(split[0]);
				int minutes = Integer.parseInt(split[1]);
				double seconds = Double.parseDouble(split[2]);
				return new Time(hour,minutes,seconds);
				} catch(NumberFormatException e) {
				throw new InputMismatchException();
			} 
			
		}
}

    
	

	
                           