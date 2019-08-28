package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int customers = scan.nextInt(); //number of customers
		double[] totals = new double[customers]; //array of total value of purchases
		String[] firstnames = new String[customers]; //array for name storage
		String[] lastnames = new String[customers];
		int items = 0; //declare number of item types variable
		
		for (int i = 0; i< customers; i++ )
		{
			//store name of customers
			firstnames[i] = scan.next();
			lastnames[i] = scan.next();
			//store number of items he/she has w/ local variable
			items = scan.nextInt();
			//storage for each items totals, names of items
			double[] totalperitem = new double[items];
			String[] itemname = new String[items];
			int quantity = 0;
			
			for (int j = 0; j< items; j++)
			{
				quantity = scan.nextInt();
				itemname[j] = scan.next();
				double costperitem = scan.nextDouble();
				totalperitem[j] = quantity * costperitem;
			}
			 
			totals[i] = calculateValueSum(totalperitem);
			
		}
		for (int i = 0; i < customers; i++) {
			System.out.println(firstnames[i].charAt(0)+". "+ lastnames[i] + ": " + String.format("%.2f", totals[i]) );
		}
		
	}
	
	//sum array method
	static double calculateValueSum(double[] vals) {
		
		double sum = 0;
		
		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}
		
		return sum;
	}
	
}
