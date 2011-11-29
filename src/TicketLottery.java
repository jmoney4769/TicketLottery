import java.util.Scanner;


public class TicketLottery {

	private String in;
	private String firstSet;
	private String secondSet;
	private String thirdSet;
	private String fourthSet;
	private int group;
	private int tickets;
	private int winners;
	private int totalPeople;
	private double probability;

	public String[] getInput() {
		
		Scanner input = new Scanner(System.in);
		
		int counter = 0;
		
		System.out.print(""); 
		in = input.next();
		
		char array[] = in.toCharArray();
		String straArray[] = new String[array.length];
		
		for (int i = 0; i < array.length; i++) { 
			// convert array of characters to array of single letter strings so can be made into ints			
			if (array[i] != ' ')
				straArray[i] = Character.toString(array[i]);
			else if (array[i] == ' ') {
				straArray[i] = "a"; // "check" value, will indicate when to go to next int				
				counter++; // count ' 's to make sure correctly formatted
			}
		}
		
		return straArray;
	}
	
	private void getSets(String[] strArray) { // split input into four sets
		
		int checker = 0; // to tell when to add to which set
		
		for (int i = 0; i < strArray.length; i++) {
			
			if ((strArray[i] != "a") && (checker == 0))
				firstSet += strArray[i];
			if ((strArray[i] != "a") && (checker == 1))
				secondSet += strArray[i];
			if ((strArray[i] != "a") && (checker == 2))
				thirdSet += strArray[i]; 
			if ((strArray[i] != "a") && (checker == 3))
				fourthSet += strArray[i];
			
			if (strArray[i] == "a")
				checker++;
		}
	}
	
	private void makeInts() {
		
		getSets(getInput());
		
		try {
			if (firstSet != null)
				totalPeople = Integer.parseInt(firstSet);
			if (secondSet != null)
				winners = Integer.parseInt(secondSet);
			if (thirdSet != null)
				tickets = Integer.parseInt(thirdSet);
			if (fourthSet != null)
				group = Integer.parseInt(fourthSet);
		}
		catch (Exception e) {
			System.out.println(in + " is illegal");
			System.exit(0);
		}
	}
	
	private void calculateProbability() {
		
		probability = winners / totalPeople;
	}
}
