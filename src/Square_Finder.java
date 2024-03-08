import java.util.Scanner;

public class Square_Finder {
	/**
	 * Main method to execute the program.
	 * Prompts the user to enter a number to find its square.
	 * Allows the user to exit the program by typing 'exit'.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Square Finder");
		while (true) {
			System.out.println("\nEnter a number to start the program");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {
				System.exit(0);
			} else {
				try {
					// Calculate square if the input is a valid number
					double num = Double.parseDouble(ex);
					double sqr = num * num;
					System.out.println("The Square of " + num + " is " + sqr + ".");
				} catch (NumberFormatException e) {
					System.out.println(ex + " is an invalid number");
				}
			}
		}
	}
}