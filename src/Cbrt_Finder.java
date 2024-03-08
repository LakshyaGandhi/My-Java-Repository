import java.util.Scanner;

/**
 * This program calculates the cube root of a user-inputted number.
 * It prompts the user to input a number, validates the input,
 * and calculates the cube root using Math.cbrt() method.
 */
public class Cbrt_Finder {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Cube Root Finder");
		while (true) {
			System.out.println("\nEnter a number to start the program");
			System.out.println("OR Type 'exit' to quit the program."); // user input for typing the number o
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				default:
					try {
						float num = Float.parseFloat(ex);
						if (num - Math.floor(num) == 0) { // checking if user inputted number is whole or decimal
							float cbrt = (float) Math.cbrt(num);
							System.out.println("The Cube Root of " + num + " is " + cbrt + ".");
						} else {
							System.out.println("Invalid Input. Enter a Whole Number");
							break;
						}
						break;
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid number");
					}
			}
		}
	}
}