import java.util.Scanner;

public class Factors_of_No {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Factor Finder");
		
		// Infinite loop to keep the program running
		while (true) {
			// Prompt user for input selection
			System.out.println("\nType 1 - To find Factors of Positive Numbers");
			System.out.println("Type 2 - To find Factors of Negative Numbers");
			System.out.println("OR Type 'exit' to quit the program");
			System.out.print("Enter your choice = ");
			// Read user input
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			
			// Process user input
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				case "1":
					// Find factors of a positive number
					System.out.print("Enter a positive number = ");
					Scanner sc = new Scanner(System.in);
					String x = sc.nextLine();
					try {
						long num = Long.parseLong(x);
						long i = 1;
						if (i <= num) {
							for (i = 1; i <= num; ++ i) {
								if (num % i == 0) {
									System.out.print(i + " ");
								}
							}
						} else if (num == 0) {
							System.out.println("Entered number should not be zero");
						} else {
							System.out.println("Entered number should be positive");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid number");
					}
					break;
				
				case "2":
					// Find factors of a negative number
					System.out.print("Enter a negative number = ");
					Scanner scan = new Scanner(System.in);
					String y = scan.nextLine();
					try {
						long num1 = Long.parseLong(y);
						long i1 = - 1;
						if (i1 <= num1) {
							for (i1 = - 1; i1 <= Math.abs(num1); ++ i1) {
								if (i1 == 0) {
									continue;
								} else {
									if (num1 % i1 == 0) {
										System.out.print(i1 + " ");
									}
								}
							}
						} else {
							System.out.println("Entered number should be negative");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid number");
					}
					break;
				
				default:
					System.out.println("Invalid Input.");
			}
		}
	}
}