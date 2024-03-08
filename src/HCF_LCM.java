import java.util.Scanner;

public class HCF_LCM {
	/**
	 * Main method to execute the program.
	 * This program calculates the Highest Common Factor (HCF) and Least Common Multiple (LCM)
	 * of two numbers provided by the user.
	 * The user can input two numbers, and the program will compute the HCF and LCM using
	 * the Euclidean algorithm.
	 * If the user types 'exit', the program will terminate.
	 * If the user inputs any non-numeric characters, the program will prompt again for valid input.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("HCF and LCM Calculator");
		while (true) {
			System.out.println("\nEnter first number to start the program");
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
						Long.parseLong(ex);
						Scanner sc = new Scanner(System.in);
						long n1 = Long.parseLong(ex);
						System.out.println("Enter second number");
						String num = sc.nextLine();
						try {
							long n2 = Long.parseLong(num);
							long on1 = n1; // Store the original value of the first number
							long on2 = n2; // Store the original value of the second number
							// Calculate the Greatest Common Divisor (GCD) using Euclidean algorithm
							while (n1 % n2 != 0) {
								long remainder = n1 % n2;
								n1 = n2;
								n2 = remainder;
							}
							long gcd = n2; // Store the calculated GCD
							// Calculate the Least Common Multiple (LCM)
							long lcm = (on1 * on2) / gcd;
							System.out.println("The HCF of " + on1 + " and " + on2 + " is = " + gcd);
							System.out.println("The LCM of " + on1 + " and " + on2 + " is = " + lcm);
						} catch (NumberFormatException e) {
							System.out.println(num + " is not a valid number");
						}
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid number");
					}
			}
		}
	}
}