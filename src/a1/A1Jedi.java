package a1;

import java.util.Scanner;

public class A1Jedi {

public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		/*Reads items stored in the shop and what each customer bought.
		 *Input: number of different items in store, THEN FOR EACH ITEM, name of item, cost of that item, THEN
		 * 		 number of customers, number of items they bought, THEN FOR EACH BOUGHT ITEM, quantity purchased, name of item
		 *Output: -number of customers that bought each item
		 * 		  -how many items of that type was bought
		 * 
		 * **A1Jedi has a lot of unnecessary next() methods as it takes A1Adept inputs**
		 */
		
			// inventory list set up
		int numberProducts = scan.nextInt(); 
		
		String[] productNames = new String[numberProducts];
		double[] productPrices = new double[numberProducts];
		
			// sales stats for each item set up
		int[] productSales = new int[numberProducts];
		int[] productUniqueCustomers = new int[numberProducts];	
		
		for (int i = 0; i < numberProducts; i ++) {
			productNames[i] = scan.next();				//records names and prices for each product
			productPrices[i] = scan.nextDouble();
		}
			
			// customer list set up
		int numberCustomers = scan.nextInt();
		
		String[] firstNames = new String[numberCustomers];
		String[] lastNames = new String[numberCustomers];
	
		for (int i = 0; i < numberCustomers; i++ ) {
			firstNames[i] = scan.next();				//records the names for each customer (names unused but sets scanenr up)
			lastNames[i] = scan.next();
			
			int numberItems = scan.nextInt();
			
			boolean[] hasPurchased = new boolean[numberProducts]; //array created for each customer with index being the product id
			
			for (int j = 0; j < numberItems; j ++) {		//goes through each product customer bought
				int quantity = scan.nextInt();
				String itemName = scan.next();
				int itemIndex = lookUpIndexString(itemName, productNames);
				
				if (itemIndex != -1) {		//sees if customer's product actually exists in the product list
					hasPurchased[itemIndex] = true;
				}
				
				productSales[itemIndex] = productSales[itemIndex] + quantity;
				
			}
			
			for (int k = 0; k < numberProducts; k++ ) { 	//goes through boolean list to see if a customer bought an item
				if (hasPurchased[k]) {
					productUniqueCustomers[k] ++;
				}
			}
			
		}

				//formatting for output, uses ternary operator to check for 0s in customers bought n items
		
		for (int i = 0; i < numberProducts; i++) {
			System.out.println( (productUniqueCustomers[i] == 0 ? "No" : productUniqueCustomers[i]) + " customers bought " + (productSales[i] == 0 ? "" : productSales[i] + " ") + productNames[i]);
		}
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
	

}
