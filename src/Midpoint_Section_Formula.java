import java.util.Scanner;

public class Midpoint_Section_Formula {
	
	/**
	 * Function to simplify a fraction to its simplest form.
	 *
	 * @param numerator   The numerator of the fraction.
	 * @param denominator The denominator of the fraction.
	 * @return An array containing the simplified numerator and denominator.
	 */
	public static double[] simplest_form_fraction(double numerator, double denominator) {
		double[] result = new double[2];
		float n_abs = (float) Math.abs(numerator); // Absolute value of the numerator
		float d_abs = (float) Math.abs(denominator); // Absolute value of the denominator
		//? Loop to find the greatest common divisor
		for (int i = 2; i <= Math.min(n_abs, d_abs); i++) {
			while (n_abs % i == 0 && d_abs % i == 0) { // Check if both numerator and denominator are divisible by i
				n_abs /= i;
				d_abs /= i;
			}
		}
		//? Loop to find the greatest common divisor
		for (int i = 2; i <= Math.min(numerator, denominator); i++) {
			while (numerator % i == 0 && denominator % i == 0) { // Check if both numerator and denominator are divisible by i
				numerator /= i;
				denominator /= i;
			}
		}
		if (numerator == 0 || denominator == 0)
			numerator = 0; // If numerator or denominator is zero, set numerator to 0
		else if (numerator > 0 && denominator == 1)
			numerator = (int) n_abs; // If numerator is positive and denominator is 1
		else if (numerator < 0 && denominator == 1)
			numerator = (int) n_abs * - 1; // If numerator is negative and denominator is 1
		else if (numerator > 0 && denominator == - 1)
			numerator = (int) n_abs * - 1; // If numerator is positive and denominator is -1
		else if (numerator < 0 && denominator == - 1)
			numerator = (int) n_abs; // If numerator is negative and denominator is -1
		else if (numerator > 0 && denominator > 0)
			numerator = (int) n_abs; // If both numerator and denominator are positive
		else if (numerator < 0 && denominator < 0)
			numerator = (int) n_abs; // If both numerator and denominator are negative
		else if (numerator > 0 && denominator < 0)
			numerator = (int) n_abs * - 1; // If numerator is positive and denominator is negative
		else if (numerator < 0 && denominator > 0)
			numerator = (int) n_abs * - 1; // If numerator is negative and denominator is positive
		
		result[0] = numerator;
		result[1] = denominator;
		return result; // Return the result array
	}
	
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Midpoint and Section Formula");
		while (true) {
			Scanner sc = new Scanner(System.in);
			double x1 = 0, x2 = 0, y1 = 0, y2 = 0;
			System.out.println("\nEnter coordinates of Point A:");
			System.out.print("x1: ");
			String a = sc.nextLine();
			try {
				x1 = Double.parseDouble(a);
				System.out.print("y1: ");
				a = sc.nextLine();
				try {
					y1 = Double.parseDouble(a);
					System.out.println("Enter coordinates of Point B:");
					System.out.print("x2: ");
					a = sc.nextLine();
					try {
						x2 = Double.parseDouble(a);
						System.out.print("y2: ");
						a = sc.nextLine();
						try {
							y2 = Double.parseDouble(a);
						} catch (NumberFormatException e) {
							System.out.println("Invalid Number");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid Number");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid Number");
			}
			
			System.out.println("Type 1: Find Point P which divides AB");
			System.out.println("Type 2: Find ratio divided by Point P in AB");
			System.out.println("OR Type 'exit' to quit the program.");
			System.out.print("Enter your choice: ");
			String ex = sc.nextLine();
			String ext = ex.toLowerCase();
			
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				case "1":
//				Find Point P which divides AB
					System.out.println("Enter ratio:");
					System.out.print("m: ");
					a = sc.nextLine();
					try {
						double m = Double.parseDouble(a);
						System.out.print("n: ");
						a = sc.nextLine();
						try {
							double n = Double.parseDouble(a);
							// Calculate the coordinates of Point P
							double P_xN, P_xD, P_yN, P_yD;
							P_xD = m + n;
							P_yD = m + n;
							P_xN = ((m * x2) + (n * x1));
							P_yN = ((m * y2) + (n * y1));
							System.out.println("\ncoordinates of Point P:");
							double[] resultX = simplest_form_fraction(P_xN, P_xD); //Call func @simplest_form_fraction
							double[] resultY = simplest_form_fraction(P_yN, P_yD); //Call func @simplest_form_fraction
							if ((P_xN / P_xD) != (int) (P_xN / P_xD) || (P_yN / P_yD) != (int) (P_yN / P_yD)) {
								System.out.println("x = " + (int) resultX[0] + " / " + (int) resultX[1]);
								System.out.println("y = " + (int) resultY[0] + " / " + (int) resultY[1]);
								System.out.println("\n\t\t\tOR");
							}
							System.out.println("x = " + (P_xN / P_xD) + ", " + (P_yN / P_yD));
							break;
						} catch (NumberFormatException e) {
							System.out.println("Invalid Number");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
					break;
				
				// Case for finding ratio divided by Point P in AB
				case "2":
					// Print the message for selecting values to enter
					System.out.println("Please select either values to enter: ");
					System.out.println("Type 1: Value of x in Point P");
					System.out.println("Type 2: Value of y in Point P");
					ex = sc.nextLine();
					ext = ex.toLowerCase();
					double m, n;
					switch (ext) {
						// Case for exiting the program
						case "exit":
							System.exit(0);
							break;
						
						// Case for entering the value of x in Point P
						case "1":
							System.out.print("Enter value of x (Point P): ");
							a = sc.nextLine();
							try {
								// Try parsing the input to a double
								double x = Double.parseDouble(a);
								n = Math.abs(x2 - x);
								m = Math.abs(x1 - x);
								double[] result = simplest_form_fraction(m, n); //Call func @simplest_form_fraction
								if (result[0] == (int) result[0] && result[1] == (int) result[1])
									System.out.println("m : n = " + (int) result[0] + " : " + (int) result[1]);
								else System.out.println("m : n = " + result[0] + " : " + result[1]);
							} catch (NumberFormatException e) {
								// Catch block for handling invalid number
								System.out.println("Invalid Number");
							}
							break;
						
						case "2":
							System.out.print("Enter value of y (Point P): ");
							a = sc.nextLine();
							try {
								double y = Double.parseDouble(a);
								n = Math.abs(y2 - y); // calculate absolute difference between y2 and y
								m = Math.abs(y1 - y); // calculate absolute difference between y1 and y
								double[] result = simplest_form_fraction(m, n); //Call func @simplest_form_fraction
								if (result[0] == (int) result[0] && result[1] == (int) result[1]) // check if result is integer
									System.out.println("m : n = " + (int) result[0] + " : " + (int) result[1]);
								else System.out.println("m : n = " + result[0] + " : " + result[1]);
							} catch (NumberFormatException e) {
								System.out.println("Invalid Number");
							}
							break;
						
						default:
							System.out.println("Invalid Choice");
					}
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}