package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		/* Program that reads shopping data and reports amount each customer spends.
		 * Input: In this order, separated by spaces;
		 *		<number of customers> <first name> <last name> <number of different items> <name of item> <cost of one item>
		 *			^This input is repeated accordingly based on number of customers and number of different items. 
		 * Output: For each customer;
		 * 		<first initial of name>. <last name>: <total money spent>
		 */
		
		int customers = scan.nextInt(); //gets number of customers
		
		double[] totals = new double[customers]; //array holding totals each customer spends
		String[] firstNames = new String[customers]; //array holding the names of the customers
		String[] lastNames = new String[customers];
		
		
		for (int i = 0; i< customers; i++ )
		{
			firstNames[i] = scan.next(); //obtains name of customers i
			lastNames[i] = scan.next();
			
			int items = scan.nextInt(); //gets number of different items customer i has

			double[] totalperitem = new double[items]; //array holding total spent on each item customer i has
			String[] itemname = new String[items]; //array holding the name of each item
			
			for (int j = 0; j< items; j++)
			{
				int quantity = scan.nextInt(); //gets quantity of a specific item purchased
				
				itemname[j] = scan.next(); //stores the name of that item (not necessary for A1Novice)
				
				double costperitem = scan.nextDouble(); //gets cost of one of that item
				
				totalperitem[j] = quantity * costperitem; //calculates and stores amount spent on a specific item
			}
			 
			totals[i] = calculateArraySum(totalperitem); //adds up the total purchases of each item
			
		}
		
		for (int i = 0; i < customers; i++) { //prints out total spending for each customer
			System.out.println(firstNames[i].charAt(0)+". "+ lastNames[i] + ": " + String.format("%.2f", totals[i]) );
		}
		
	}
	
	/* Adds up each number in an array.
	 * Input: double array
	 * Output: total as a double
	 */
	
	static double calculateArraySum(double[] vals) {
		
		double sum = 0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		return sum;
	}
	
}
