import java.util.Scanner;

public class Positive_Negative {
	/**
	 * Main method to execute the Positive_Negative program.
	 * Prompts the user to input a number and determines if it is positive, negative, or zero.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Positive and Negative Number Finder");
		// Continuous loop to keep the program running until user exits
		while (true) {
			System.out.println("\nEnter a Positive or Negative number to start the program");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {
				System.exit(0);
			} else {
				try {
					double num = Double.parseDouble(ex);
					// Check if the number is positive, negative, or zero
					if (num > 0.0) {
						System.out.println("The number " + num + " is Positive.");
					} else if (num < 0.0) {
						System.out.println("The number " + num + " is Negative.");
					} else {
						System.out.println("The number " + num + " is Neither Positive nor Negative.");
					}
				} catch (NumberFormatException e) {
					System.out.println(ex + " is an invalid number");
				}
			}
		}
	}
}