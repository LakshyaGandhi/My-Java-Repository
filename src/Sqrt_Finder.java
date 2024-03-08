import java.util.Scanner;

public class Sqrt_Finder {
	/**
	 * Finds the square root of a whole number entered by the user.
	 * If the input is not a whole number or not a valid number, it prompts the user accordingly.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Square Root Finder");
		
		// Infinite loop to continuously prompt for user input
		while (true) {
			System.out.println("\nEnter a number to start the program");
			System.out.println("OR Type 'exit' to quit the program.");
			
			// Input handling
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			
			if (ext.equals("exit")) {
				System.exit(0);
			} else {
				try {
					float num = Float.parseFloat(ex);
					// Check if the number is a whole number
					if (num - Math.floor(num) == 0) {
						float sqrt = (float) Math.sqrt(num);
						System.out.println("The Square Root of " + num + " is " + sqrt + ".");
					} else {
						System.out.println("Invalid Input. Enter a Whole Number");
						continue;
					}
				} catch (NumberFormatException e) {
					System.out.println(ex + " is an invalid number");
				}
			}
		}
	}
}