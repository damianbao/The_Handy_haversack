/**
 *  Name: EBookStore Part2
 *  Description: Project six
 *  Author:  Brad Staier
 *  Due Date: 07/10/18
 *  Pledged: I pledge that I have upheld the Non-Collaboration Policy.
 *
 */
 
 // imports
 import java.util.Scanner;
 /**
  @author  bradstaier
 */
 
 public class EBookStore2 {
 	// methods for calculations

 	/**
 	  * this ensures that the number input is a postive double
 	  * @param numEBooks The number of eBooks downloaded
 	  * @return the double that has passed the evaluation
 	*/
 	public static double scanDouble(int numEBooks) {
        Scanner in = new Scanner(System.in);
        boolean okay = true; // flag, setinel value
        double num = 0;
        double cost = 0;
 		

	        while (okay) { 	
	        	for (int i=1; i<=numEBooks; i++) {
	 				System.out.printf("Please enter the cost of eBook #%d:\n", i);
		 			while (!in.hasNextDouble()) {
		 			String text = in.next();
		 			System.out.println("Error: please enter a number: ");
		  			}
			  		// if I'm here, they did type an integer
			  		num = in.nextDouble();
			  		if (num >0) {
			  			okay = false;
			  		}
			  		else {
			  			System.out.println("Error: please enter a positive number: ");
			  		}
					cost = num +cost;
	 			 	
	 			}
 		 
		}return cost;
 	} 
       	
       	/**
 	  * this ensures that the number input is a postive integer
 	  * @param input the text that identifies the query
 	  * @param lowBound the low limit 
 	  * @param highBound the high limit 
 	  * @return the double that has passed the evaluation
 		*/
 	
 	public static int scanInt(String input, int lowBound, int highBound) {
		Scanner in = new Scanner(System.in);
		boolean okay = true; // flag, setinel value
		int num = 0;
		int memLow = 0;
		int memHigh =3;
		String MEMBERSTATUS = "your memebership status.\n0 for not a member.\n1 for bronze member.\n2 for a silver member.\n3 for a gold member.";

		userPrompt(input);

		

		while (okay) { 		
 			while (!in.hasNextInt()) {
 			String text = in.next();
 			System.out.printf("Error: please enter a valid integer between %d and %d\n",
 			lowBound, 
 			highBound);
  			}
	  		// if I'm here, they did type an integer
	  		num = in.nextInt();

	  		if (input == MEMBERSTATUS) {
	  			lowBound = memLow;
	  			highBound = memHigh;
	  		} 

	  		if (num >= lowBound && num <= highBound) {
	  			okay = false;
	  		} else {
	  			System.out.printf("Error: please enter a valid integer between %d and %d\n",
	  				lowBound,
	  				highBound);
	  		}
 		}return num;
 	} 

 

    /**
 	  * this method returns the service charge
 	  * @param base the base cost of ebooks purchased
 	  * @param charge the service charge rate for number of ebooks
 	  * @return the total service charge cost
 	*/

 	public static double serviceCharge(double base, double charge) {
 		return base * charge;
 	}

 	/**
 	  * this method calculates and returns the product charge
 	  * @param base the base cost of ebooks purchased
 	  * @param service the total service charge cost
 	  * @return the adjust total including service charge
 	*/
 	
 	public static double productCharge(double base, double service) {
 		return base + service; 		
	}

 	/**
 	  * this method calculates the member's discount
 	  * @param product the adjust total including service charge
 	  * @param memDiscount the member discount rate
 	  * @return the member discount amount
 	*/
 	
 	public static double discount(double product, double memDiscount) {
 		return product * memDiscount;	
	}

 	/**
 	  * this method calculates and returns the subtotal
 	  * @param product the adjust total including service charge
 	  * @param discount the member discount amount
 	  * @return the total after the discount and before taxes
 	*/
 	
 	public static double subtotal(double product, double discount) {
 		return product - discount;
 	}

 	/**
 	  * this method calculates and returns the salesTax
 	  * @param subTotal the total after the discount and before taxes
 	  * @param tax the tax rate
 	  * @return the total sales taxes
 	*/
 	
 	public static double salesTax(double subTotal, double tax) {
 		return subTotal * tax; 		 
 	}

 	/**
 	  * this method calculates and returns the salesTax
 	  * @param subTotal the total after the discount and before taxes
 	  * @param tax the tax rate
 	  * @return the total including sales taxes
 	*/
 	
 	public static double total(double subTotal, double tax) {
 		return subTotal + tax; 		 
 	}

 	/**
 	  * this method prompts the user for input.
 	  * @param input the query to be given the user
 	*/

 	public static void userPrompt(String input) {
 		System.out.printf("Please enter %s: ", input);
 		System.out.println("");
 	}
 	 
 	public static void doItAll() {
 		Scanner scan = new Scanner(System.in);
 		

 		// constants
 		final double TAX_RATE = 0.055;

 		final double GOLD_DISCOUNT = 0.2;
 		final double SILVER_DISCOUNT = 0.15;
 		final double BRONZE_DISCOUNT = 0.1;
 		final double NON_MEMBER_DISCOUNT = 0.0; 

 		final double CHARGE_UP_TO_8 = 0.07;
 		final double CHARGE_8_TO_UNDER15 = 0.05;
 		final double CHARGE_15_TO_UNDER20 = 0.03;
 		final double CHARGE_20_PLUS = 0.0; 	

 		final String FIRSTNAME = "your first name";
 		final String LASTNAME ="your lastname";
 		final String NUMBEROFEBOOKS = "the number of eBooks downloaded between 1 and 25";
 		final String COSTPERBOOK = "the cost per eBook: ";
 		final String MEMBERSTATUS = "your memebership status.\n0 for not a member.\n1 for bronze member.\n2 for a silver member.\n3 for a gold member.";

 		
 		// variables
 		String fName;
 		String lName;
 		int numEBooks = 0;
 		double eBookPrice = 0.0;
 		int memStat = 0;
 		double bCharge = 0;
 		double sCharge = 0;
 		double pCharge = 0;
 		double dCount = 0;
 		double sTotal = 0;
 		double sTax = 0;
 		double total = 0;
 		double totalTaxes = 0;
 		int totalCustomers = 0;
 		int totalBooks = 0;
 		double totalSales = 0;
 		int customers =0;
 		char userAnswer;


 		
 		// input
 		userPrompt(FIRSTNAME);
 		fName = scan.nextLine();
 		userPrompt(LASTNAME);		
 		lName = scan.nextLine();

 		numEBooks = scanInt(NUMBEROFEBOOKS, 1, 25);	

 		eBookPrice = scanDouble(numEBooks); 
 		memStat = scanInt(MEMBERSTATUS, 0, 3);


		// calculations
		bCharge = eBookPrice;
		
		if (numEBooks <= 8) {
			sCharge = serviceCharge(
			bCharge,
			CHARGE_UP_TO_8);
 		}
 		if (numEBooks > 8 && numEBooks <= 15) {
 			sCharge = serviceCharge(
			bCharge,
			CHARGE_8_TO_UNDER15);
 		}
 		if (numEBooks > 15 && numEBooks < 20) {
 			sCharge = serviceCharge(
			bCharge,
			CHARGE_15_TO_UNDER20); 			
 		}
 		if (numEBooks >= 20) {
 			sCharge = serviceCharge(
			bCharge,
			CHARGE_20_PLUS);
 		}
 		pCharge = productCharge(bCharge, sCharge);

		if (memStat == 3) {
 		 	dCount = discount(pCharge, GOLD_DISCOUNT);
	 	}
 		if (memStat == 2) {
 		 	dCount = discount(pCharge, SILVER_DISCOUNT);
 		}
 		if (memStat == 1) {
 		 	dCount = discount(pCharge, BRONZE_DISCOUNT);
	 	}
 		if (memStat == 0) {
 		 	dCount = discount(pCharge, NON_MEMBER_DISCOUNT);
	 	}
		sTotal = subtotal(pCharge, dCount);
		sTax = salesTax(sTotal, TAX_RATE);
		total = total(sTotal, sTax);

		// output
		System.out.printf("Full Name: \t\t %s %s\n", fName, lName);
		System.out.printf("eBooks downloaded: \t\t %d\n", numEBooks);
 		System.out.printf("\nBase Charge:\t\t $%.2f\n\n", bCharge);
 		System.out.printf("Service Charge:\t\t $%.2f\n\n", sCharge);
 		System.out.printf("Product Charge:\t\t $%.2f\n\n", pCharge);
 		System.out.printf("Discount:\t\t $%.2f\n\n", dCount);
		System.out.printf("Subtotal:\t\t $%.2f\n\n", sTotal);
 		System.out.printf("Sales Tax:\t\t $%.2f\n\n", sTax);
 		System.out.printf("Total:\t\t\t $%.2f\n\n", total);

 		totalTaxes = totalTaxes+sTax;
 		totalCustomers = totalCustomers + 1;
 		totalBooks = totalBooks + numEBooks;
 		totalSales = totalSales + total;

 		

 		System.out.println("Is there another customer? (Y/N) ==>");

 		userAnswer = scan.next().charAt(0);

 		if (userAnswer == 'Y' || userAnswer == 'y') {
 			System.out.println("");
	 		System.out.println("Today's Totals");
 			System.out.println();
 			System.out.printf("Total number of customer: %d\n", totalCustomers);
 			System.out.printf("Total number of eBooks: %d\n", totalBooks);
 			System.out.printf("Total taxes: %.2f\n", totalTaxes);
 			System.out.printf("Total sales: %.2f\n", totalSales);
 			doItAll();
 		} else {

			totalTaxes = totalTaxes+sTax;
	 		totalCustomers = totalCustomers + 1;
	 		totalBooks = totalBooks + numEBooks;
	 		totalSales = totalSales + total;
	 			
	 		System.out.println("");
	 		System.out.println("Today's Totals");
 			System.out.println();
 			System.out.printf("Total number of customer: %d\n", totalCustomers);
 			System.out.printf("Total number of eBooks: %d\n", totalBooks);
 			System.out.printf("Total taxes: %.2f\n", totalTaxes);
 			System.out.printf("Total sales: %.2f\n", totalSales);
 		}
 	}


 		
 
 	/**
 	  * This main method querries the user for info on the ebook account 
 	  * and returns pertinent information
 	  * @param args executes the methods and outputs the results
 	*/
 	
 	public static void main(String[] args) {
 		doItAll();


 		
 		
 		
	

	
 	}		

 }


 	 
 
