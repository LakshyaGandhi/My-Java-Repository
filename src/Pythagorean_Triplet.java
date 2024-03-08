import java.util.Scanner;

public class Pythagorean_Triplet {
	// Class to check for Pythagorean triplets
	
	/**
	 * Prints whether the given numbers form a Pythagorean triplet or not.
	 *
	 * @param num1 The first number.
	 * @param num2 The second number.
	 * @param num3 The third number.
	 */
	public static void printSolution(double num1, double num2, double num3) {
		// Calculate squares and check for Pythagorean triplet
		double num1sqr = Math.pow(num1, 2);
		double add = (num2 * num2) + (num3 * num3);
		if (num1sqr == add) {
			System.out.println("Numbers: " + (int) num1 + ", " + (int) num2 + ", " + (int) num3 + " are Pythagorean Triplets.");
		} else {
			System.out.println("It's not a Pythagorean Triplet.");
		}
	}
	
	/**
	 * Main method to execute the program.
	 * Continuously prompts the user to enter numbers until 'exit' is typed.
	 * Validates input to ensure it's a valid number.
	 * Determines the largest number among the entered values.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Pythagorean Triplet Verifier");
		while (true) {
			System.out.println("\nEnter 1st number");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {
				System.exit(0);
			} else {
				try {
					double num1 = Double.parseDouble(ex);
					System.out.print("Enter second number = ");
					String n2 = extscan.nextLine();
					try {
						double num2 = Double.parseDouble(n2);
						System.out.print("Enter third number = ");
						String n3 = extscan.nextLine();
						try {
							// Convert the input to double for the third number
							// Check which number is the largest among the entered values and call the printSolution method accordingly
							double num3 = Double.parseDouble(n3);
							if (num1 >= num2 && num1 >= num3) {
								printSolution(num1, num2, num3);
							} else if (num2 >= num1 && num2 >= num3) {
								printSolution(num2, num1, num3);
							} else {
								printSolution(num3, num1, num2);
							}
						} catch (NumberFormatException e) {
							System.out.println(n2 + " is not a valid number");
						}
					} catch (NumberFormatException e) {
						System.out.println(n2 + " is not a valid number");
					}
				} catch (NumberFormatException e) {
					System.out.println(ex + " is not a valid number");
				}
			}
		}
	}
}