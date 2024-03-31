import java.util.Scanner;

public class Equation_of_line {
	/**
	 * This method simplifies the fraction by reducing the numerator and denominator to their lowest terms.
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
		String out = "";
		if (numerator == 0 || denominator == 0) // if n=0 or d=0
			out = "0.0";
		else if (numerator > 0 && denominator == 1) // if n=pos and d=1
			out += n_abs;
		else if (numerator < 0 && denominator == 1) // if n=neg and d=1
			out = "-" + n_abs;
		else if (numerator > 0 && denominator == - 1) // if n=pos and d=-1
			out = "-" + n_abs;
		else if (numerator < 0 && denominator == - 1) // if n=neg and d=-1
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
	 * This method takes user input for two points and returns an array of their coordinates.
	 *
	 * @return An array of four integers: x1, y1, x2, y2.
	 */
	public static int[] input2Points() {
		int[] result = new int[4];
		Scanner sc = new Scanner(System.in);
		StringBuilder A;
		StringBuilder B;
		System.out.print("Enter the coordinates of point A: ");
		A = new StringBuilder(sc.nextLine());
		System.out.print("Enter the coordinates of point B: ");
		B = new StringBuilder(sc.nextLine());
		//Remove parenthesis
		if (A.charAt(0) == '(') A.delete(0, 1);
		if (A.charAt(A.length() - 1) == ')') A.delete(A.length() - 1, A.length());
		if (B.charAt(0) == '(') B.delete(0, 1);
		if (B.charAt(B.length() - 1) == ')') B.delete(B.length() - 1, B.length());
		result[0] = Integer.parseInt(A.substring(0, A.indexOf(",")));
		result[1] = Integer.parseInt(A.substring(A.indexOf(",") + 1, A.length()));
		result[2] = Integer.parseInt(B.substring(0, B.indexOf(",")));
		result[3] = Integer.parseInt(B.substring(B.indexOf(",") + 1, B.length()));
		return result;
	}
	
	public static void main(String[] args) {
		//Welcome message
		System.out.println("Equation of Line Calculator");
		System.out.println("NOTE: Format to write coordinates: (x,y) i.e., no spaces");
		Scanner sc = new Scanner(System.in);
		// Prompt user for input selection
		System.out.println("\nType 1: Find slope of two points");
		System.out.println("Type 2: Find equation of line");
		System.out.println("OR Type 'exit' to quit the program.");
		System.out.print("Enter your choice: ");
		String ex = sc.nextLine();
		String ext = ex.toLowerCase();
		int[] temp;
		int x1, y1, x2, y2, c;
		double m;
		StringBuilder eqn = new StringBuilder();
		switch (ext) {
			case "exit":
				System.exit(0);
				break;
			
			case "1":
//				Find Slope
				System.out.println("Type 1: Input 2 points");
				System.out.println("Type 2: Input Equation of line");
				System.out.println("OR Type 'exit' to quit the program.");
				System.out.print("Enter your choice: ");
				ex = sc.nextLine();
				ext = ex.toLowerCase();
				switch (ext) {
					case "exit":
						System.exit(0);
						break;
					
					case "1": //Two points
						//! m = (y2 - y1) / (x2 - x1)
						temp = input2Points(); //Call func @input2Points
						x1 = temp[0];
						y1 = temp[1];
						x2 = temp[2];
						y2 = temp[3];
						System.out.println("\nGiven points are: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")");
						System.out.print("The slope of the line is ");
						if ((y2 - y1) % (x2 - x1) == 0) System.out.print((y2 - y1) / (x2 - x1));
						else if ((x2 - x1) % (y2 - y1) == 0) System.out.print((x2 - x1) / (y2 - y1));
						else simplest_form_fraction(y2 - y1, x2 - x1); //Call func @simplest_form_fraction
						break;
					
					case "2": //Equation
						//! m = -a/b
						System.out.print("Enter co-efficient of x: "); // ax, where 'a' is the coefficient of x
						double a = sc.nextDouble();
						System.out.print("Enter co-efficient of y: "); //by, where 'b' is the coefficient of y
						double b = sc.nextDouble();
						System.out.print("Slope: ");
						simplest_form_fraction(- a, b); //Call func @simplest_form_fraction
						break;
					
					default:
						System.out.println("Invalid input");
				}
				break;
			
			case "2":
//				Find Equation of Line
				System.out.println("Type 1: Input slope and y-intercept");
				System.out.println("Type 2: Input slope and a point");
				System.out.println("Type 3: Input 2 points");
				System.out.println("OR Type 'exit' to quit the program.");
				System.out.print("Enter your choice: ");
				ex = sc.nextLine();
				ext = ex.toLowerCase();
				switch (ext) {
					case "exit":
						System.exit(0);
						break;
					
					case "1": //Slope Intercept Form
						//! y = mx + c
						System.out.print("Enter slope: ");
						m = sc.nextDouble();
						System.out.print("Enter y-intercept: ");
						c = sc.nextInt();
						int y = 1;
						//If m is not an integer, then multiply all values by 10
						if (! (m == (int) m)) {
							while (! (m == (int) m)) {
								m *= 10;
								y *= 10;
								c *= 10;
							}
						}
						//Simplify m, y and c into the lowest terms
						for (int i = 2; i <= 10; i++) {
							while (m % i == 0 && y % i == 0 && c % i == 0) {
								m /= i;
								y /= i;
								c /= i;
							}
						}
						System.out.print("The equation of line is: ");
						if (m == 1) eqn.append("x ");
						else if (m == - 1) eqn.append("-x ");
						else eqn.append((int) m).append("x ");
						y *= - 1;
						if (y == 1) eqn.append("+").append("y ");
						else if (y == - 1) eqn.append("-y ");
						else {
							if (y > 0) eqn.append("+").append(y).append("y ");
							else eqn.append(y).append("y ");
						}
						if (c < 0) eqn.append(c);
						else eqn.append("+").append(c);
						eqn.append(" = 0");
						System.out.println(eqn);
						break;
					
					case "2": //Slope Point Form
						//! y - y1 = m(x - x1)
						System.out.print("Enter slope: ");
						String tmp = sc.nextLine();
						System.out.print("Enter the coordinates of point A: ");
						StringBuilder A = new StringBuilder(sc.nextLine());
						//Remove parenthesis
						if (A.charAt(0) == '(') A.delete(0, 1);
						if (A.charAt(A.length() - 1) == ')') A.delete(A.length() - 1, A.length());
						x1 = Integer.parseInt(A.substring(0, A.indexOf(",")));
						y1 = Integer.parseInt(A.substring(A.indexOf(",") + 1, A.length()));
						System.out.println("Given point is: (" + x1 + "," + y1 + ")");
						//if m is fraction
						if (tmp.contains("/")) {
							int slash = tmp.indexOf("/");
							String t1 = tmp.substring(0, slash);
							String t2 = tmp.substring(slash + 1);
							String t3 = t1.trim();
							String t4 = t2.trim();
							int m_n = Integer.parseInt(t3);
							int m_d = Integer.parseInt(t4);
							for (int i = 2; i <= 10; i++) {
								while (m_n % i == 0 && m_d % i == 0) {
									m_n /= i;
									m_d /= i;
								}
							}
							c = (- m_n * x1) + (m_d * y1);
							System.out.print("Equation of line is: ");
							if (m_n == 1) eqn.append("x ");
							else if (m_n == - 1) eqn.append("-").append("x ");
							else eqn.append(m_n).append("x ");
							if (m_d == 1) eqn.append("-").append(m_d).append("y ");
							else if (m_d == - 1) eqn.append("+").append(m_d).append("y ");
							else {
								if (m_d > 0) eqn.append("-").append(m_d).append("y ");
								else if (m_d < 0) eqn.append("+").append(m_d).append("y ");
								else eqn.append("+").append(m_d).append("y ");
							}
						} else { //else m is a non-fraction
							m = Integer.parseInt(tmp);
							c = (int) ((- m * x1) + y1);
							System.out.print("Equation of line is: ");
							if (m == (int) m) {
								if ((int) m == 1) eqn.append("x ");
								else if ((int) m == - 1) eqn.append("-x ");
								else eqn.append((int) m).append("x ");
							} else {
								if (m == 1) eqn.append("x ");
								else if (m == - 1) eqn.append("-x ");
								else eqn.append(m).append("x ");
							}
							eqn.append("-y ");
						}
						if (c < 0) eqn.append(c);
						else eqn.append("+").append(c);
						eqn.append(" = 0");
						System.out.println(eqn);
						break;
					
					case "3": //Two Point Form
						//! (y - y1)(y2 - y1) = (x - x1)(x2 - x1)
						temp = input2Points(); //Call @input2Points
						x1 = temp[0];
						y1 = temp[1];
						x2 = temp[2];
						y2 = temp[3];
						System.out.println("\nGiven points are: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")");
						int a = y2 - y1, b = x2 - x1;
						c = (a * x1 * - 1) + (b * y1);
						//convert a,b and c into the lowest terms
						for (int i = 2; i <= 10; i++) {
							while (a % i == 0 && b % i == 0 && c % i == 0) {
								a /= i;
								b /= i;
								c /= i;
							}
						}
						System.out.print("The equation of line is: ");
						if (a != 0 && b != 0) {
							if (a == 1) eqn.append("x ");
							else if (a == - 1) eqn.append("-x ");
							else eqn.append(a).append("x ");
							if (b == 1) eqn.append("-y ");
							else if (b == - 1) eqn.append("+").append("y ");
							else {
								b *= - 1;
								if (b < 0) eqn.append(b).append("y ");
								else eqn.append("+").append(b).append("y ");
							}
							if (c < 0) eqn.append(c);
							else eqn.append("+").append(c);
							eqn.append(" = 0");
							System.out.println(eqn);
						}
						break;
					
					default:
						System.out.println("Invalid Option");
				}
				break;
			
			default:
				System.out.println("Invalid Option");
		}
	}
}