package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		/*Reads items stored in the shop and what each customer bought.
		 *Input: number of different items in store, THEN FOR EACH ITEM, name of item, cost of that item, THEN
		 * 		 number of customers, number of items they bought, THEN FOR EACH BOUGHT ITEM, quantity purchased, name of item
		 *Output: -the largest spender's name and how much they spent
		 * 		  -the smallest spender's name and how much they spent
		 * 		  -average spending of all the customers
		 */
		
			// inventory list set up
		int numberProducts = scan.nextInt(); 
		
		String[] productNames = new String[numberProducts];
		double[] productPrices = new double[numberProducts];
		
		for (int i = 0; i < numberProducts; i ++) {
			productNames[i] = scan.next();				//records names and prices for each product
			productPrices[i] = scan.nextDouble();
		}
			
			// customer list set up
		int numberCustomers = scan.nextInt();
		
		String[] firstNames = new String[numberCustomers];
		String[] lastNames = new String[numberCustomers];
		double[] customerTotals = new double[numberCustomers];
		
		for (int i = 0; i < numberCustomers; i++ ) {
			firstNames[i] = scan.next();				//records the names for each customer
			lastNames[i] = scan.next();
			
			int numberItems = scan.nextInt();
			
			double[] itemTotals = new double[numberItems];
			
			for (int j=0; j < numberItems; j ++) {		//for each customer's items, finds how much they spent for a product
				int quantity = scan.nextInt();
				String itemName = scan.next();
				int itemIndex = lookUpIndexString(itemName, productNames);
				itemTotals[j] = quantity*productPrices[itemIndex];
			}
			
			customerTotals[i] = calculateArraySum(itemTotals); //sums all individual product totals for a customer
			
		}

		int largeIndex = lookUpIndexDouble(findValueMax(customerTotals), customerTotals); //finds the customer index of who spent most and least
		int smallIndex = lookUpIndexDouble(findValueMin(customerTotals), customerTotals);
		
				//formatting for output
		System.out.println("Biggest: " + firstNames[largeIndex] + " " + lastNames[largeIndex] + " (" + String.format("%.2f", customerTotals[largeIndex]) + ")");
		System.out.println("Smallest: " + firstNames[smallIndex] + " " + lastNames[smallIndex] + " (" + String.format("%.2f", customerTotals[smallIndex]) + ")" );
		System.out.println( "Average: " + String.format("%.2f",calculateArraySum(customerTotals) / firstNames.length));
		
	}
	
	/* lookUpIndexString - searches a String array for a matching String
	 * Inputs: word to look for, array to look in
	 * Outputs: -1 if word not found OR
	 * 			last matching index number if word found 
	 */
	
	static int lookUpIndexString(String lookUpWord, String[] fromArray) {
		int index = -1;
		for (int i=0; i < fromArray.length; i++) {
			if (lookUpWord.equals(fromArray[i])) {
				index = i;
			}
		}
				
		return index;
	}
	
	/* lookUpIndexDouble - searches a double array for a matching double
	 * Inputs: number to look for, array to look in
	 * Outputs: -1 if number not found OR
	 * 			last matching index number if number is found
	 */
	static int lookUpIndexDouble(double lookUpNumber, double[] fromArray) {
		int index = -1;
		for (int i=0; i < fromArray.length; i++) {
			if (Math.abs(lookUpNumber - fromArray[i]) < .01) {
				index = i;
			}
		}
		
		return index;
	}
	
	/* Adds up each number in an array.
	 * Input: double array
	 * Output: total as a double
	 * **Alteration of KMP's calculateValueSum method in A1Example.
	 */
	
	static double calculateArraySum(double[] vals) {
		
		double sum = 0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		return sum;
	}
	/* Searches a double array for the highest value
	 * Inputs: a double array
	 * Outputs: the largest value in array
	 * **Alteration of KMP's findValueMax method in AlExample. 
	 */
	
	static double findValueMax(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_max = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] > cur_max) {
				cur_max = vals[i];
			}
		}
		
		return cur_max;
	}
	/* Searches a double array for the smallest value
	 * Inputs: a double array
	 * Outputs: the smallest value in array
	 * **Alteration of KMP's findValueMin method in AlExample.
	 */
	
	static double findValueMin(double[] vals) {
		
		// Initialize current minimum to first value in array.
		double cur_min = vals[0];
		
		// Starting with second value (if any), compare each value
		// in array with current minimum and replace if smaller.
		
		for (int i=1; i < vals.length; i++) {
			if (vals[i] < cur_min) {
				cur_min = vals[i];
			}
		}
		
		return cur_min;
	}
	
}
