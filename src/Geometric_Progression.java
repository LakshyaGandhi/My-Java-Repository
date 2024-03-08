import java.util.Scanner;

public class Geometric_Progression {
	/**
	 * Generates subscript for numerical representation.
	 *
	 * @param a Integer value to be represented as subscript.
	 * @return String containing subscript representation of the input.
	 */
	public static String subScript(int a) {
		// Initialize an empty string
		String s = "";
		// Convert the input integer to a string
		String sa = Integer.toString(a);
		// Iterate over each character in the string
		for (int i = 0; i < sa.length(); i++) {
			// Check each character and append the corresponding subscript character
			if (sa.charAt(i) == '1') s += "\u2081";
			else if (sa.charAt(i) == '2') s += "\u2082";
			else if (sa.charAt(i) == '3') s += "\u2083";
			else if (sa.charAt(i) == '4') s += "\u2084";
			else if (sa.charAt(i) == '5') s += "\u2085";
			else if (sa.charAt(i) == '6') s += "\u2086";
			else if (sa.charAt(i) == '7') s += "\u2087";
			else if (sa.charAt(i) == '8') s += "\u2088";
			else if (sa.charAt(i) == '9') s += "\u2089";
			else if (sa.charAt(i) == '0') s += "\u2080";
		}
		// Return the resulting subscript string
		return s;
	}
	
	/**
	 * Main method to run the Geometric Progression Solver program.
	 * Allows users to perform various operations related to Geometric Progressions.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Geometric Progression");
		while (true) {
			System.out.println("\nType - 1: Find t\u2099"); // Prompt user to choose an operation
			System.out.println("Type - 2: Find number of terms");
			System.out.println("Type - 3: Print a G.P.");
			System.out.println("Type - 4: Check if it's an G.P.");
			System.out.println("Type - 5: Find/Check if a number is in an G.P.");
			System.out.println("Type - 6: Find Sum of a G.P.");
			System.out.println("OR Type 'exit' to quit the program.");
			System.out.print("Enter your choice: ");
			Scanner sc = new Scanner(System.in);
			String ex = sc.nextLine();
			String ext = ex.toLowerCase();
			double a, r, n, S, tn = 0;
			String x, y, z;
			String ss;
			System.out.print("Enter the first term: a = ");
			x = sc.nextLine();
			try {
				a = Double.parseDouble(x);
				switch (ext) {
					case "exit":
						System.exit(0);
						break;
					
					case "1":
						System.out.print("Enter the constant ratio: r = "); // Prompt the user to enter the constant ratio
						y = sc.nextLine(); // Read the input from the user
						try {
							r = Double.parseDouble(y);
							System.out.print("Enter the term you want to find: n = ");
							z = sc.nextLine();
							try {
								n = Double.parseDouble(z);
								ss = subScript((int) n); // Assign the result of the subScript function to variable ss
								System.out.println("t" + ss + " = " + (a * (Math.pow(r, (n - 1))))); // Print the result of the geometric progression calculation
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "2":
						System.out.print("Enter the constant ratio: r = ");
						y = sc.nextLine();
						try {
							r = Double.parseDouble(y);
							System.out.print("Enter the last term: tₙ = ");
							z = sc.nextLine();
							try {
								tn = Double.parseDouble(z);
								n = (tn * r) / a; // Calculate the number of terms in the series
								boolean m = false; // Initialize boolean variable m to false
								for (int i = 1; Math.pow(r, i) <= n; i++) { // Iterate through the series
									if (Math.pow(r, i) == n && Math.pow(r, i) <= n) { // Check if the term matches the number of terms
										n = i; // Assign the index to variable n
										m = true;
										break;
									}
								}
								if (m)
									System.out.println("Number of terms: " + (int) n); // Print the number of terms if m is true
								else
									System.out.println("The term you entered is not in the series."); // Print error message if m is false
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "3":
						System.out.print("Enter the constant ratio: r = ");
						y = sc.nextLine();
						try {
							r = Double.parseDouble(y);
							System.out.print("Print G.P. till 'n' terms: n = ");
							z = sc.nextLine();
							try {
								n = Double.parseDouble(z);
								if (n == (int) n) { // Check if the number of terms is an integer
									if (a == (int) a)
										System.out.print((int) a); // Print the initial term as integer if it's an integer
									else System.out.print(a); // Print the initial term
									for (int i = 2; i <= n; i++) { // Loop to calculate and print the geometric progression
										a *= r;
										if (a == (int) a)
											System.out.print(", " + (int) a); // Print the next term as integer if it's an integer
										else System.out.print(", " + a);
									}
									System.out.print(", .........."); // Print ellipsis to indicate continuation
								} else
									System.out.println("'n' should not be a decimal. It is the number of terms to be printed."); // Error message for non-integer number of terms
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "4":
						System.out.print("Enter the second term: t\u2082 = ");
						y = sc.nextLine();
						try {
							double t2 = Double.parseDouble(y);
							System.out.print("Enter the third term: t\u2083 = ");
							z = sc.nextLine();
							try {
								double t3 = Double.parseDouble(z);
								if ((t2 / a) == (t3 / t2))
									System.out.println("It's a G.P."); // Check if the terms form a geometric progression and print the result
								else System.out.println("It's not a G.P."); // Print the result
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "5":
						System.out.print("Enter the constant ratio: r = "); // Prompt for constant ratio input
						y = sc.nextLine(); // Read the input
						try {
							r = Double.parseDouble(y); // Convert the input to double
							System.out.print("Enter the term you want to find/check: n = "); // Prompt for the term input
							z = sc.nextLine(); // Read the input
							try {
								tn = Double.parseDouble(z); // Convert the input to double
								n = (tn * r) / a; // Calculate the term number in the geometric progression
								boolean m = false;
								for (int i = 1; Math.pow(r, i) <= n; i++) { // Loop to find the term number in the geometric progression
									if (Math.pow(r, i) == n && Math.pow(r, i) <= n) { // Check if the term number matches
										n = i; // Update the term number
										m = true; // Set the flag to true
										break; // Exit the loop
									}
								}
								if (tn == (int) tn) { // Check if the term is an integer
									if (m) System.out.println((int) tn + " is the term of G.P."); // Print the result
									else System.out.println((int) tn + " is not the term of G.P."); // Print the result
								} else {
									if (m) System.out.println(tn + " is the term of G.P."); // Print the result
									else System.out.println(tn + " is not the term of G.P."); // Print the result
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid number"); // Error message for invalid input
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number"); // Error message for invalid input
						}
						break;
					
					case "6":
						System.out.print("Enter the constant ratio: r = "); // Prompt for constant ratio input
						y = sc.nextLine(); // Read the input
						try {
							r = Double.parseDouble(y); // Convert the input to double
							System.out.print("Sum till 'n' terms: n = "); // Prompt for number of terms input
							z = sc.nextLine(); // Read the input
							try {
								n = Double.parseDouble(z); // Convert the input to double
								if (n == (int) n) { // Check if the number of terms is an integer
									S = (a * ((Math.pow(r, n)) - 1)) / (r - 1); // Calculate the sum of the geometric progression
									ss = subScript((int) n); // Get the subscript for the sum
									if (S == (int) S) System.out.println("S" + ss + " = " + (int) S); // Print the sum
									else System.out.println("S" + ss + " = " + S); // Print the sum
								} else
									System.out.println("'n' should not be a decimal. It is the number of terms."); // Error message for non-integer number of terms
							} catch (NumberFormatException e) {
								System.out.println("Invalid number"); // Error message for invalid input
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number"); // Error message for invalid input
						}
						break;
					
					default:
						System.out.println("Invalid Choice");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid number");
			}
		}
	}
}