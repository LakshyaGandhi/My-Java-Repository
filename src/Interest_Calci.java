import java.util.Scanner;

public class Interest_Calci {
	/**
	 * Main method to calculate simple and compound interest based on user input.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Simple and Compound Interest Calculator");
		// Continuous loop for user input
		while (true) {
			System.out.println("\nEnter the Principal Amount (To start the program)");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				default:
					try {
						Scanner sc = new Scanner(System.in);
						double P = Double.parseDouble(ex);
						// Input for rate of interest
						System.out.print("Enter the Rate of Interest = ");
						String y = sc.nextLine();
						try {
							double R = Double.parseDouble(y);
							// Input for time period in years
							System.out.print("Enter the Time Period in Years = ");
							String z = sc.nextLine();
							try {
								double T = Double.parseDouble(z);
								// Calculate simple interest
								double SIformula = (P * R * T) / 100;
								// Calculate compound interest
								double CIformula = P * (Math.pow((1 + R / 100), T));
								// Print results
								System.out.printf("\nThe Simple Interest is = Rs %,.2f", SIformula);
								System.out.printf("\nThe Compound Interest is = Rs %,.2f", CIformula);
							} catch (NumberFormatException e) {
								System.out.println("Invalid Number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid Number");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
			}
		}
	}
}
