import java.util.Scanner;

/**
 * This program calculates the average of two numbers provided by the user.
 * It prompts the user to input two numbers and calculates their average.
 * The program continues to prompt for input until the user types 'exit'.
 */
public class Average {
	
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Two - Digit Average Finder");
		while (true) {
			System.out.println("\nEnter your first number to start the program");
			System.out.println("OR Type 'exit' to quit the program."); // user input for typing first number or exit
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				default:
					try {
						Double.parseDouble(ex);
						java.util.Scanner sc = new java.util.Scanner(System.in);
						double num1 = Double.parseDouble(ex);
						System.out.print("Enter second number = "); // asking input for second number
						String n2 = sc.nextLine();
						try {
							double num2 = Double.parseDouble(n2);
							// finding average by adding all numbers and dividing it by 2, & then printing the values
							System.out.println("The Average of " + num1 + " and " + num2 + " is " + (num1 + num2) / 2);
						} catch (NumberFormatException e) {
							System.out.println(n2 + " is not a valid number");
						}
						break;
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid number");
					}
			}
		}
	}
}