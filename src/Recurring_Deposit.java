import java.util.Scanner;

/**
 * Recurring_Deposit class calculates various aspects of a recurring deposit.
 * User can input principal amount, number of months, rate of interest, and maturity value.
 * Then, the program provides options to calculate maturity value, interest, rate of interest, principal, or period.
 */
public class Recurring_Deposit {
	/**
	 * simplest_form_fraction method simplifies a fraction to its simplest form.
	 *
	 * @param numerator   The numerator of the fraction.
	 * @param denominator The denominator of the fraction.
	 * @return An array containing the simplified numerator and denominator.
	 */
	public static double[] simplest_form_fraction(double numerator, double denominator) {
		double[] result = new double[2];
		float n_abs = (float) Math.abs(numerator);
		float d_abs = (float) Math.abs(denominator);
		// Simplifying fraction
		for (int i = 2; i <= Math.min(n_abs, d_abs); i++) {
			while (n_abs % i == 0 && d_abs % i == 0) {
				n_abs /= i;
				d_abs /= i;
			}
		}
		// Handling negative and zero values
		if (numerator == 0 || denominator == 0) numerator = 0;
		else if (numerator > 0 && denominator == 1) numerator = (int) n_abs;
		else if (numerator < 0 && denominator == 1) numerator = (int) n_abs * - 1;
		else if (numerator > 0 && denominator == - 1) numerator = (int) n_abs * - 1;
		else if (numerator < 0 && denominator == - 1) numerator = (int) n_abs;
		else if (numerator > 0 && denominator > 0) numerator = (int) n_abs;
		else if (numerator < 0 && denominator < 0) numerator = (int) n_abs;
		else if (numerator > 0 && denominator < 0) numerator = (int) n_abs * - 1;
		else if (numerator < 0 && denominator > 0) numerator = (int) n_abs * - 1;
		// Assigning simplified values to result array
		result[0] = numerator;
		result[1] = denominator;
		return result;
	}
	
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Recurring Deposit Calculator");
		System.out.println("Note: You can enter any values if you want to find that particular value of it.");
		while (true) {
			System.out.print("\nEnter the Principal: ");
			String a_ = sc.nextLine();
			try {
				double P = Double.parseDouble(a_);
				System.out.print("Enter the n(months): ");
				String b_ = sc.nextLine();
				try {
					double n = Double.parseDouble(b_);
					System.out.print("Enter the Rate of Interest: ");
					String c_ = sc.nextLine();
					try {
						double R = Double.parseDouble(c_);
						System.out.print("Enter the Maturity Value/Amount: ");
						String d_ = sc.nextLine();
						try {
							double MV = Double.parseDouble(d_);
							
							System.out.println("\nType 1: Find Maturity Value & Interest");
							System.out.println("Type 2: Find Rate of Interest");
							System.out.println("Type 3: Find Principal");
							System.out.println("Type 4: Find Period");
							System.out.println("OR Type 'exit' to quit the program.");
							System.out.print("Enter your choice: ");
							String ex = sc.nextLine();
							String ext = ex.toLowerCase();
							
							double I_n, I_d;
							
							switch (ext) {
								case "exit":
									System.exit(0);
									break;
								
								case "1":
									// Calculate and display interest and maturity value
									double I1 = (P * n * (n + 1) * R) / (2400);
									double MV1 = (P * n) + I1;
									System.out.printf("Interest = Rs %,.2f", I1);
									System.out.printf("\nMaturity Value = Rs %,.2f", MV1);
									break;
								
								case "2":
									// Calculate and display rate of interest
									I_n = P * n * (n + 1);
									I_d = 2400;
									double x = MV - (P * n);
									double y = (x * I_d) / I_n;
									System.out.println("Rate of Interest = " + y + " % per annum.");
									break;
								
								case "3":
									// Calculate and display monthly installment amount
									I_n = (n * (n + 1) * R);
									I_d = 2400;
									double[] result = simplest_form_fraction(I_n, I_d);
									double N = result[0];
									double D = result[1];
									double x4 = D * MV;
									double y4 = n * D;
									double z4 = x4 / (y4 + N);
									System.out.printf("\nThe monthly installment amount is: Rs %,.2f", z4);
									break;
								
								case "4":
									// Calculate and display period using quadratic equation
									double I5_n = (P * R);
									double I5_d = 2400;
									double[] result1 = simplest_form_fraction(I5_n, I5_d);
									double N5 = result1[0];
									double D5 = result1[1];
									double a = N5; // coefficients a, b, and c of a quadratic equation
									double b = (P * D5) + N5;
									double c = (MV * D5) * - 1;
									System.out.println("Equation: " + (int) a + "n^2 + " + (int) b + "n " + (int) c);
									double numerator_pos, numerator_neg;
									double Dis = Math.sqrt((b * b) - 4 * a * c);
									b *= - 1;
									numerator_pos = b + Dis;
									numerator_neg = b - Dis;
									double denominator = 2 * a;
									double x1 = numerator_pos / denominator;
									double x2 = numerator_neg / denominator;
									System.out.println("Therefore, x = " + x1 + " OR " + x2);
									if (x1 < 0)
										System.out.println("-> n = " + (int) x2 + " month(s), " + (x2 / 12) + " year(s)");
									else
										System.out.println("-> n = " + (int) x1 + " month(s), " + (x1 / 12) + " year(s)");
									break;
								
								default:
									System.out.println("Invalid Input");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid Value");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Value");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid Value");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid Value");
			}
		}
	}
}