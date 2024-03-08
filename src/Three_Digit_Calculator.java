import java.util.Scanner;

/**
 * A simple three-digit calculator program.
 * This program prompts the user to input three numbers and select an operation
 * (addition, subtraction, multiplication, division, or stop) to perform on them.
 * It then prints the result of the selected operation.
 */
public class Three_Digit_Calculator {
	/**
	 * Prints the solution of the operation performed on three numbers.
	 *
	 * @param num1      The first number.
	 * @param num2      The second number.
	 * @param num3      The third number.
	 * @param operation The operation performed (addition, subtraction, multiplication, or division).
	 * @param operator  The result of the operation.
	 */
	public static void printSolution(double num1, double num2, double num3, String operation, double operator) {
		System.out.println("The " + operation + " for " + num1 + ", " + num2 + " and " + num3 + " is " + operator + ".");
	}
	
	/**
	 * Main method to execute the three-digit calculator program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Three Digit Calculator");
		while (true) {
			// Prompt user for input
			System.out.println("\nEnter first number to execute the program");
			System.out.println("Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				default:
					try {
						double num1 = Double.parseDouble(ex);
						System.out.println("Enter your second number");
						Scanner scan1 = new Scanner(System.in);
						String y = scan1.nextLine();
						try {
							double num2 = Double.parseDouble(y);
							System.out.println("Enter your third number");
							String z = scan1.nextLine();
							try {
								double num3 = Double.parseDouble(z);
								// Prompt user to select an operation
								System.out.println("Type 0 - Addition");
								System.out.println("Type 1 - Subtraction");
								System.out.println("Type 2 - Multiplication");
								System.out.println("Type 3 - Division");
								System.out.println("Type 9 - Stop executing the program");
								System.out.print("Enter your choice: ");
								// Calculate operations
								double add = num1 + num2 + num3;
								double sub = num1 - num2 - num3;
								double mul = num1 * num2 * num3;
								double div = num1 / num2 / num3;
								String input = scan1.nextLine();
								switch (input) {
									case "0":
										// Print solution for addition
										printSolution(num1, num2, num3, "addition", add);
										break;
									
									case "1":
										// Print solution for subtraction
										printSolution(num1, num2, num3, "subtraction", sub);
										break;
									
									case "2":
										// Print solution for multiplication
										printSolution(num1, num2, num3, "multiplication", mul);
										break;
									
									case "3":
										// Print solution for division
										printSolution(num1, num2, num3, "division", div);
										// Calculate remainder
										double remainder = num1 % num2 % num3;
										System.out.println("Final Remainder left = " + remainder);
										break;
									
									case "9":
										System.exit(0);
										break;
									
									default:
										System.out.println("Invalid Input");
								}
							} catch (NumberFormatException e) {
								System.out.println(z + " is not a valid number");
							}
						} catch (NumberFormatException e) {
							System.out.println(y + " is not a valid number");
						}
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid number");
					}
			}
		}
	}
}