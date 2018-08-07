/**
 *  Description: prints a wind chill teimperature chart using nested loops
 *  Author:  Brad Staier
 *  Due Date: 7/17/18
 *  Pledged: I pledge that I have upheld the Non-Collaboration Policy.
 *
 */
 
 // imports

 /**
  @author  bradstaier
 */
 
 public class WindChill {

 	/**
 	  * 
 	*/
 	 
 	public static void main(String[] args) {

 		System.out.println();
 		System.out.println("Wind Chill Chart");
 		System.out.println("Y axis: Wind Velocity, X axis: Temperature");
 		System.out.println();
 		System.out.println("---------------------------------------------------------------------------------------------------------------");
 		
 		// print out most of the table , except for the very last row
 		// (when i = 0)
 		for (int i=60; i>=5; i-=5) {
 			
 			
 			System.out.printf("%2d | ", i);
 			
 			for (int j=-20; j<=35; j+=5) {
 				
 				double windChill = 35.74 + 
									0.6215*j
									- 35.75
									* Math.pow(i, .16)
									+ 0.4275*j
									*Math.pow(i, .16);
 				
 				System.out.printf("%6.1f", windChill);
 			}
 			System.out.println();	
 		}
 		// if we are here i = 0, and we can print the last row
 	
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.print("     ");
 			for (int j=-20; j<=35; j+=5) {
 				System.out.printf("%6.1f", (double)j);
 			}
 	}

} 
 	 
