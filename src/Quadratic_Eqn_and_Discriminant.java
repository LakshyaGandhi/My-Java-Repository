import java.util.Scanner;

public class Quadratic_Eqn_and_Discriminant {
	/**
	 * Method to simplify the fraction to its simplest form.
	 * @param numerator Numerator of the fraction.
	 * @param denominator Denominator of the fraction.
	 */
	public static void simplest_form_fraction(double numerator, double denominator) {
		float n_abs = (float) Math.abs(numerator);
		float d_abs = (float) Math.abs(denominator);
		for (int i = 2; i <= Math.min(n_abs, d_abs); i++) {
			while (n_abs % i == 0 && d_abs % i == 0) {
				n_abs /= i;
				d_abs /= i;
			}
		}
		String out = "";
		if (numerator == 0 || denominator == 0) // if n=0 or d=0
			out = "0.0";
		else if (numerator > 0 && denominator == 1) // if n=pos and d=1
			out += n_abs;
		else if (numerator < 0 && denominator == 1) // if n=neg and d=1
			out = "-" + n_abs;
		else if (numerator > 0 && denominator == -1) // if n=pos and d=-1
			out = "-" + n_abs;
		else if (numerator < 0 && denominator == -1) // if n=neg and d=-1
			out += n_abs;
		else if (numerator > 0 && denominator > 0) // if n=pos and d=pos
			out = n_abs + " / " + d_abs;
		else if (numerator < 0 && denominator < 0) // if n=neg and d=neg
			out = n_abs + " / " + d_abs;
		else if (numerator > 0 && denominator < 0) // if n=pos and d=neg
			out = "-" + n_abs + " / " + d_abs;
		else if (numerator < 0 && denominator > 0) // if n=neg and d=pos
			out = "-" + n_abs + " / " + d_abs;
		
		System.out.print(out);
	}
	
	/**
	 * Main method to execute the program.
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quadratic Equation and Discriminant Finder");
		while (true) {
			System.out.print("Enter value of a = ");
			String x = sc.nextLine();
			double a = 0, b = 0, c = 0;
			try {
				a = Double.parseDouble(x);
				System.out.print("Enter value of b = ");
				String y = sc.nextLine();
				try {
					b = Double.parseDouble(y);
					System.out.print("Enter value of c = ");
					String z = sc.nextLine();
					try {
						c = Double.parseDouble(z);
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid Number");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid Number");
			}
			if (a != 0) {
				System.out.println("Type 1: Quadratic Equation Finder");
				System.out.println("Type 2: Discriminant Finder");
				System.out.println("Type 'exit' to quit the program.");
				System.out.print("Enter your choice = ");
				String ex = sc.nextLine();
				String ext = ex.toLowerCase();
				double D = (b * b) - 4 * a * c; // D=Discriminant
				switch (ext) {
					case "exit":
						System.exit(0);
						break;
					case "1": { // Quadratic Equation
						double numerator_pos, numerator_neg;
						numerator_pos = -b + Math.sqrt(D);
						numerator_neg = -b - Math.sqrt(D);
						double denominator = 2 * a;
						if ((numerator_pos / denominator) != (int) (numerator_pos / denominator) || (numerator_neg / denominator) != (int) (numerator_neg / denominator)) {
							// if numerator=pos
							System.out.print("x = ");
							simplest_form_fraction(numerator_pos, denominator);
							System.out.print(", ");
							// if numerator=neg
							simplest_form_fraction(numerator_neg, denominator);
							System.out.println("\n\t\t\tOR");
						}
						System.out.println("x = " + (numerator_pos / denominator) + ", " + (numerator_neg / denominator));
						break;
					}
					case "2": { // Discriminant
						System.out.println("D = " + D);
						if (D == 0)
							System.out.println("D = 0. Roots are real and equal.");
						else if (D > 0)
							System.out.println("D > 0. Roots are real and unequal.");
						else if (D < 0)
							System.out.println("D < 0. Roots are imaginary (not real).");
						break;
					}
					default:
						System.out.println("Invalid Choice");
				}
			} else {
				System.out.println("Value of 'a' should not be equal to ZERO.");
			}
		}
	}
}