import java.util.Scanner;

public class Cube_Finder {
	/**
	 * Main method to execute the Cube Finder program.
	 * Prompts the user to enter a number and calculates its cube.
	 * Allows the user to exit the program by typing 'exit'.
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Cube Finder");
		while (true) {
			// Prompt user to enter a number or exit
			System.out.println("\nEnter a number to start the program");
			System.out.println("OR Type 'exit' to quit the program.");
			
			// User input for typing the number or exit
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			
			// Switch statement to handle user input
			switch (ext) {
				case "exit":
					System.exit(0); // Exit the program
					break;
					
				default:
					try {
						// Parse input to check if it's a valid number
						Double.parseDouble(ex);
						double num = Double.parseDouble(ex);
						// Cubing the inputted number i.e. multiplying number three times
						double cube = num * num * num;
						System.out.println("The Cube of " + num + " is " + cube + ".");
						break;
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid number");
					}
			}
		}
	}
}
