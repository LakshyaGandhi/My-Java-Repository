import java.util.Scanner;

/**
 * This program offers three different tools: a calculator, an odd-even number identifier,
 * and a prime number spotter.
 */
public class Three_In_One {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Three in One Tool");
		while (true) {
			System.out.println("\nType 1 - The Countless Calci");
			System.out.println("Type 2 - The Odd-Even Seeker");
			System.out.println("Type 3 - The Prime Number Spotter");
			System.out.println("Type 'exit' to exit the tool");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				// Exit option
				case "exit":
					System.exit(0);
					break;
				// Calculator tool
				case "1":
					System.out.println("Enter your first number");
					Scanner scan1 = new Scanner(System.in);
					String x = scan1.nextLine();
					try {
						double num1 = Double.parseDouble(x);
						System.out.println("Enter your second number");
						String y = scan1.nextLine();
						try {
							double num2 = Double.parseDouble(y);
							System.out.println("Type 0 - Addition");
							System.out.println("Type 1 - Subtraction");
							System.out.println("Type 2 - Multiplication");
							System.out.println("Type 3 - Division");
							System.out.println("Type 9 and hit enter to stop executing the program");
							double sum = num1 + num2;
							double sub = num1 - num2;
							double mul = num1 * num2;
							double div = num1 / num2;
							int input = scan1.nextInt();
							switch (input) {
								case 0:
									System.out.println("The addition for " + num1 + " and " + num2 + " is " + sum + ".");
									break;
								
								case 1:
									System.out.println("The subtraction for " + num1 + " and " + num2 + " is " + sub + ".");
									break;
								
								case 2:
									System.out.println("The multiplication for " + num1 + " and " + num2 + " is " + mul + ".");
									break;
								
								case 3:
									System.out.println("The division for " + num1 + " and " + num2 + " is " + div + ".");
									double remainder = num1 % num2;
									System.out.println("Remainder left = " + remainder);
									break;
								
								case 9:
									System.exit(0);
									break;
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid Input");
						}
						
					} catch (NumberFormatException e) {
						System.out.println("Invalid Input");
					}
					break;
				
				// Odd-even seeker tool
				case "2":
					System.out.println("Type a number = ");
					Scanner scan2 = new Scanner(System.in);
					String z = scan2.nextLine();
					try {
						long n = Long.parseLong(z);
						if (n % 2 == 0) {
							System.out.println("The number " + n + " is Even.");
							break;
						} else {
							System.out.println("The number " + n + " is Odd.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Input");
					}
					break;
				
				// Prime number spotter tool
				case "3":
					System.out.println("Find a prime number between 1 and ");
					Scanner scan3 = new Scanner(System.in);
					String a = scan3.nextLine();
					try {
						long pn = Long.parseLong(a);
						long s = 1;
						if (pn % 2 == 0) {
							System.out.println("Invalid Input. Enter a Prime Number");
						} else {
							do {
								System.out.println(s + " ");
								s += 2;
							} while (s <= pn);
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Input");
					}
					break;
				default:
					System.out.println("Invalid Input");
			}
		}
	}
}