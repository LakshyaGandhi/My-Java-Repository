import java.util.Scanner;

public class Odd_Or_Even {
	/**
	 * Main method to execute the program.
	 * Prompts the user to enter a number and determines if it's odd or even.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Odd or Even Number Finder");
		// Continuously prompt user for input
		while (true) {
			System.out.println("\nEnter a number to start the program");
			System.out.println("Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				default:
					try {
						long n = Long.parseLong(ex);
						if (n % 2 == 0) {
							// Number is even
							System.out.println("The number " + n + " is Even.");
						} else {
							// Number is odd
							System.out.println("The number " + n + " is Odd.");
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println(ex + " is an invalid number");
					}
			}
		}
	}
}
