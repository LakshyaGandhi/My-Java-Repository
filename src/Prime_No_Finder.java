import java.util.Scanner;

/**
 * This program finds a prime number between 1 and a user-defined number.
 * It prompts the user to enter a number, and then it checks if the entered number is prime.
 * If the entered number is even, it prints an error message.
 * Otherwise, it prints numbers starting from 1 up to the entered number.
 */
public class Prime_No_Finder {
	/**
	 * Main method to execute the program.
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Prime Number Finder");
		while (true) {
			// Prompt user for input
			System.out.println("\nFind a prime number between 1 and...");
			System.out.println("Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {// Exit program if user inputs 'exit'
				System.exit(0);
			} else {
				try {
					long pn = Long.parseLong(ex); // Convert user input to a long
					int one = 1; // Start from 1
					if (pn % 2 == 0) {
						// If input is even, print an error message
						System.out.println("Invalid Input. Enter a Prime Number");
					} else {
						// Print numbers starting from 1 up to the entered number
						do {
							System.out.print(one + " ");
							one += 2;
						} while (one <= pn);
					}
				} catch (NumberFormatException e) {
					// Catch if user enters a non-numeric value
					System.out.println(ex + " is not a valid number");
				}
			}
		}
	}
}