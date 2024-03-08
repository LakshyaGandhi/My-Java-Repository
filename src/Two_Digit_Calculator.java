import java.util.Scanner;

/**
 * A program that performs basic arithmetic operations on two-digit numbers.
 * The user inputs two numbers and selects an operation: addition, subtraction, multiplication, or division.
 * The program then calculates the result and prints it along with any remainder (in case of division).
 */
public class Two_Digit_Calculator {
	
	/**
	 * Prints the result of the arithmetic operation.
	 *
	 * @param num1      The first number.
	 * @param num2      The second number.
	 * @param operation The arithmetic operation.
	 * @param operator  The result of the operation.
	 */
	public static void printSolution(double num1, double num2, String operation, double operator) {
		System.out.println("The " + operation + " for " + num1 + " and " + num2 + " is " + operator + ".");
	}
	
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Two Digit Calculator");
		while (true) {
			// Input first number
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
						Scanner scan2 = new Scanner(System.in);
						String x = scan2.nextLine();
						try {
							double num2 = Double.parseDouble(x);
							// Choose operation
							System.out.println("Type 0 - Addition");
							System.out.println("Type 1 - Subtraction");
							System.out.println("Type 2 - Multiplication");
							System.out.println("Type 3 - Division");
							System.out.println("Type 9 - Stop executing the program");
							double add = num1 + num2;
							double sub = num1 - num2;
							double mul = num1 * num2;
							double div = num1 / num2;
							int input = scan2.nextInt();
							switch (input) {
								case 0:
									// Print solution for addition
									printSolution(num1, num2, "addition", add);
									break;
								
								case 1:
									// Print solution for subtraction
									printSolution(num1, num2, "subtraction", sub);
									break;
								
								case 2:
									// Print solution for multiplication
									printSolution(num1, num2, "multiplication", mul);
									break;
								
								case 3:
									// Print solution for division
									printSolution(num1, num2, "division", div);
									double remainder = num1 % num2;
									System.out.println("Remainder left = " + remainder);
									break;
								
								case 9:
									System.exit(0);
									break;
								
								default:
									System.out.println("Invalid Input");
							}
						} catch (NumberFormatException e) {
							System.out.println(x + " is not a valid integer");
						}
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid integer");
					}
			}
		}
	}
}