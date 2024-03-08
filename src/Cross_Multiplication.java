import java.util.Scanner;

/**
 * This program performs cross multiplication to solve a system of linear equations.
 * It prompts the user to input values for coefficients of two linear equations
 * and calculates the solution for the system using cross multiplication method.
 */
public class Cross_Multiplication {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	
	public static void main(String[] args) {
		// Print the title of the program
		System.out.println("Cross Multiplication");
		// Print a note about program limitations
		System.out.println("Note: Program only supports number(constants), not variable & fractions.");
		// Loop to keep the program running until the user exits
		while (true) {
			// Prompt the user to enter a1 or exit
			System.out.println("\nEnter value of a1 to start the program");
			System.out.println("OR Type 'exit' to quit the program."); //user input for typing first number or exit
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {
				System.exit(0);
			} else {
				try {
					// Check if the input is a valid number
					Double.parseDouble(ex);
					Scanner sc = new Scanner(System.in);
					double a1 = Double.parseDouble(ex);
					// Prompt the user to enter value of b1
					System.out.print("Enter value of b1 = ");
					String b = sc.nextLine();
					try {
						// Check if the input for b1 is a valid number
						double b1 = Double.parseDouble(b);
						// Prompt the user to enter value of c1
						System.out.print("Enter value of c1 = ");
						String c = sc.nextLine();
						try {
							// Check if the input for c1 is a valid number
							double c1 = Double.parseDouble(c);
							// Prompt the user to enter value of a2
							System.out.print("Enter value of a2 = ");
							String aa = sc.nextLine();
							try {
								// Check if the input for a2 is a valid number
								double a2 = Double.parseDouble(aa);
								// Prompt the user to enter value of b2
								System.out.print("Enter value of b2 = ");
								String bb = sc.nextLine();
								try {
									// Check if the input for b2 is a valid number
									double b2 = Double.parseDouble(bb);
									// Prompt the user to enter value of c2
									System.out.print("Enter value of c2 = ");
									String cc = sc.nextLine();
									try {
										// Check if the input for c2 is a valid number
										double c2 = Double.parseDouble(cc);
										// Perform the cross multiplication calculations
										double x = (b1 * c2) - (b2 * c1), y = (c1 * a2) - (c2 * a1), one = (a1 * b2) - (a2 * b1);
										double ansx = x / one, ansy = y / one;
										// Print the results
										System.out.println("x/" + x + " = y/" + y + " = 1/" + one);
										System.out.println("Therefore, Solution is:");
										System.out.println("(x, y) = (" + ansx + ", " + ansy + ")");
									} catch (NumberFormatException e) {
										System.out.println(cc + " is not a valid number");
									}
								} catch (NumberFormatException e) {
									System.out.println(bb + " is not a valid number");
								}
							} catch (NumberFormatException e) {
								System.out.println(aa + " is not a valid number");
							}
						} catch (NumberFormatException e) {
							System.out.println(c + " is not a valid number");
						}
					} catch (NumberFormatException e) {
						System.out.println(b + " is not a valid number");
					}
				} catch (NumberFormatException e) {
					System.out.println(ex + " is not a valid number");
				}
			}
		}
	}
}