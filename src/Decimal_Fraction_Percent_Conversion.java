import java.util.Scanner;

public class Decimal_Fraction_Percent_Conversion {
	/**
	 * Simplifies a fraction to its simplest form.
	 *
	 * @param numerator   The numerator of the fraction.
	 * @param denominator The denominator of the fraction.
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
		for (int i = 2; i <= Math.min(numerator, denominator); i++) {
			while (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
			}
		}
		
		String out = "";
		if (numerator == 0 || denominator == 0) //if n=0 or d=0
			out = "0";
		else if (numerator > 0 && denominator == 1) //if n=pos and d=1
			out += (int) n_abs;
		else if (numerator < 0 && denominator == 1) //if n=neg and d=1
			out = "-" + (int) n_abs;
		else if (numerator > 0 && denominator == - 1) //if n=pos and d=-1
			out = "-" + (int) n_abs;
		else if (numerator < 0 && denominator == - 1) //if n=neg and d=-1
			out += (int) n_abs;
		else if (numerator > 0 && denominator > 0) //if n=pos and d=pos
			out = (int) n_abs + " / " + (int) d_abs;
		else if (numerator < 0 && denominator < 0) //if n=neg and d=neg
			out = (int) n_abs + " / " + (int) d_abs;
		else if (numerator > 0 && denominator < 0) //if n=pos and d=neg
			out = "-" + (int) n_abs + " / " + (int) d_abs;
		else if (numerator < 0 && denominator > 0) //if n=neg and d=pos
			out = "-" + (int) n_abs + " / " + (int) d_abs;
		System.out.print(out);
	}
	
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Decimal, Fraction and Percentage Converter");
		while (true) {
			System.out.println("\nType 1 - Convert Decimal to Fraction & Percent");
			System.out.println("Type 2 - Convert Fraction to Decimal & Percent");
			System.out.println("Type 3 - Convert Percent to Fraction & Decimal");
			System.out.println("OR Type 'exit' to quit the program."); //asking user input for specific options
			System.out.print("Enter your choice = ");
			Scanner sc = new Scanner(System.in);
			String ex = sc.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				case "1": {     //Decimal
					//to Percent
					System.out.print("Enter a Decimal = ");
					String num = sc.nextLine();
					double num1 = 0.0;
					try {
						num1 = Double.parseDouble(num);
						float x1 = (float) (num1 * 100); //x1=decimal to percentage ie. n*100
						System.out.println("Percent: " + x1 + "%");
					} catch (NumberFormatException e) {
						System.out.println("Invalid Input. Enter a Decimal");
					}
					//to Fraction
					int d1 = 1;
					while (num1 != (int) num1) { //expressing decimal in p/q form, q=can be 10,100,1000,etc...
						num1 *= 10;
						d1 *= 10;
					}
					System.out.print("Fraction: ");
					simplest_form_fraction(num1, d1); //simplification of fraction
					break;
					
				}
				case "2": {     //Fraction
					System.out.print("Enter Numerator = ");
					String a = sc.nextLine();
					try {
						double numerator = Double.parseDouble(a);
						System.out.print("Enter Denominator = ");
						String b = sc.nextLine();
						try {
							double denominator = Double.parseDouble(b);
							//to Decimal
							double x2 = numerator / denominator; //x2=fraction to decimal (p/q)
							System.out.println("Decimal: " + x2);
							//to Percent
							double y2 = x2 * 100; //y2=fraction to percentage (p/q * 100)
							System.out.println("Percent: " + y2 + "%");
						} catch (NumberFormatException e) {
							System.out.println("Invalid Input. Enter a appropriate number.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Input. Enter a appropriate number.");
					}
					break;
					
				}
				case "3": {     //Percent
					System.out.print("Enter percentage = ");
					String f = sc.nextLine();
					try {
						double percentage4 = Double.parseDouble(f);
						if (percentage4 <= 100) {
							//to Decimal
							double x3 = percentage4 / 100; //converting percentage to decimal, dividing by 100.
							System.out.println("Decimal: " + x3);
							//to Fraction
							int d3 = 1;
							while (x3 != (int) x3) { //expressing decimal in p/q form, q=can be 10,100,1000,etc...
								x3 *= 10;
								d3 *= 10;
							}
							System.out.print("Fraction: ");
							simplest_form_fraction(x3, d3); //simplification of fraction
						} else {
							System.out.println("Percentage should be under 100.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Input. Enter a appropriate Integer.");
					}
					break;
					
				}
				default:
					System.out.println("Invalid Input");
			}
		}
	}
}