import java.util.Scanner;

public class Leap_Year_Finder {
	/**
	 * Main method to execute the Leap Year Finder program.
	 * Allows the user to input a year and determines if it's a leap year or not.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		// Display program information
		System.out.println("Leap Year and Non-Leap Year Finder");
		
		// Continuously prompt user for input
		while (true) {
			System.out.println("\nEnter a year to start the program");
			System.out.println("OR Type 'exit' to quit the program.");
			
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				default:
					try {
						long year = Short.parseShort(ex);
						// Validate if the year is within the supported range
						if (year > 999 && year < 10000) {
							// Determine if the year is a leap year or not
							if (year % 4 == 0 || year % 100 == 0 || year % 400 == 0) {
								System.out.println(year + " is a Leap Year");
							} else {
								System.out.println(year + " is a Non-Leap Year");
								break;
							}
						} else {
							System.out.println("Program doesn't support this year");
						}
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid year");
					}
			}
		}
	}
}