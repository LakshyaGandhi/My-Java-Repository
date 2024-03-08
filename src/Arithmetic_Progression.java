import java.util.Scanner;

public class Arithmetic_Progression {
	// Main class for Arithmetic Progression
	
	/**
	 * Generates subscript for numbers.
	 *
	 * @param a The number for which subscript is generated.
	 * @return Subscript string.
	 */
	public static String subScript(int a) {
		String s = "";
		String sa = Integer.toString(a);
		// Switch case statement to handle all possible values of a
		switch (sa) {
			case "1":
				s += "\u2081"; // Add subscript for 1
				break;
			case "2":
				s += "\u2082"; // Add subscript for 2
				break;
			case "3":
				s += "\u2083"; // Add subscript for 3
				break;
			case "4":
				s += "\u2084"; // Add subscript for 4
				break;
			case "5":
				s += "\u2085"; // Add subscript for 5
				break;
			case "6":
				s += "\u2086"; // Add subscript for 6
				break;
			case "7":
				s += "\u2087"; // Add subscript for 7
				break;
			case "8":
				s += "\u2088"; // Add subscript for 8
				break;
			case "9":
				s += "\u2089"; // Add subscript for 9
				break;
			case "0":
				s += "\u2080"; // Add subscript for 0
				break;
			default:
				s = ""; // Reset string
		}
		return s;
	}
	
	public static void main(String[] args) {
		// Main method to handle user input
		System.out.println("Arithmetic Progression");
		while (true) {
			// Display menu options
			System.out.println("\nType - 1: Find t\u2099"); //tn
			System.out.println("Type - 2: Find number of terms");
			System.out.println("Type - 3: Print an A.P.");
			System.out.println("Type - 4: Check if it's an A.P.");
			System.out.println("Type - 5: Find/Check if a number is in an A.P.");
			System.out.println("Type - 6: Find Sum of an A.P.");
			System.out.println("OR Type 'exit' to quit the program.");
			System.out.print("Enter your choice: ");
			Scanner sc = new Scanner(System.in);
			String ex = sc.nextLine();
			String ext = ex.toLowerCase();
			double a = 0, d = 0, n = 0, S = 0, tn = 0;
			String x = "", y = "", z = "";
			String ss;
			// Prompt for user input
			System.out.print("Enter the first term: a = ");
			x = sc.nextLine();
			try {
				a = Double.parseDouble(x);
				switch (ext) {
					case "exit":
						System.exit(0);
						break;
					
					case "1":
						System.out.print("Enter the difference: d = ");
						y = sc.nextLine();
						try {
							d = Double.parseDouble(y);
							System.out.print("Enter the term you want to find: n = ");
							z = sc.nextLine();
							try {
								n = Double.parseDouble(z);
								// Generate subscript for n
								ss = subScript((int) n);
								// Calculate nth term
								tn = a + (n - 1) * d;
								// Print result
								System.out.println("t" + ss + " = " + tn);
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "2":
						System.out.println("Find number of terms");
						System.out.print("Enter the first term: a = ");
						x = sc.nextLine();
						try {
							a = Double.parseDouble(x);
							System.out.print("Enter the difference: d = ");
							y = sc.nextLine();
							try {
								d = Double.parseDouble(y);
								System.out.print("Enter the nth term: tn = ");
								z = sc.nextLine();
								try {
									tn = Double.parseDouble(z);
									// Calculate number of terms
									n = (tn - a + d) / d;
									// Print result
									System.out.println("n = " + (int) n);
								} catch (NumberFormatException e) {
									System.out.println("Invalid number");
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "3":
						System.out.println("Print an A.P.");
						System.out.print("Enter the first term: a = ");
						x = sc.nextLine();
						try {
							a = Double.parseDouble(x);
							System.out.print("Enter the difference: d = ");
							y = sc.nextLine();
							try {
								d = Double.parseDouble(y);
								System.out.print("Enter the number of terms: n = ");
								z = sc.nextLine();
								try {
									n = Double.parseDouble(z);
									// Print A.P.
									for (int i = 0; i < n; i++) {
										if (i != n - 1) {
											System.out.print((a + i * d) + ", ");
										} else {
											System.out.println((a + i * d));
										}
									}
								} catch (NumberFormatException e) {
									System.out.println("Invalid number");
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "4":
						System.out.println("Check if it's an A.P.");
						System.out.print("Enter the first term: a = ");
						x = sc.nextLine();
						try {
							a = Double.parseDouble(x);
							System.out.print("Enter the difference: d = ");
							y = sc.nextLine();
							try {
								d = Double.parseDouble(y);
								System.out.print("Enter the number of terms: n = ");
								z = sc.nextLine();
								try {
									n = Double.parseDouble(z);
									// Check if it's an A.P.
									boolean isAP = true;
									double current = a;
									for (int i = 1; i < n; i++) {
										current += d;
										if (current != (a + i * d)) {
											isAP = false;
											break;
										}
									}
									// Print result
									if (isAP) {
										System.out.println("It's an A.P.");
									} else {
										System.out.println("It's not an A.P.");
									}
								} catch (NumberFormatException e) {
									System.out.println("Invalid number");
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "5":
						System.out.println("Find/Check if a number is in an A.P.");
						System.out.print("Enter the first term: a = ");
						x = sc.nextLine();
						try {
							a = Double.parseDouble(x);
							System.out.print("Enter the difference: d = ");
							y = sc.nextLine();
							try {
								d = Double.parseDouble(y);
								System.out.print("Enter the number of terms: n = ");
								z = sc.nextLine();
								try {
									n = Double.parseDouble(z);
									System.out.print("Enter the number to check: num = ");
									String num = sc.nextLine();
									double check = Double.parseDouble(num);
									// Check if the number is in A.P.
									if ((check - a) % d == 0 && (check - a) / d >= 0 && (check - a) / d < n) {
										System.out.println("Yes, " + num + " is in the A.P.");
									} else {
										System.out.println("No, " + num + " is not in the A.P.");
									}
								} catch (NumberFormatException e) {
									System.out.println("Invalid number");
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
						}
						break;
					
					case "6":
						// Prompt user to enter the difference
						System.out.print("Enter the difference: d = ");
						y = sc.nextLine();
						try {
							// Parse the input for the difference 'd' into a Double
							d = Double.parseDouble(y);
							// Prompt user to enter the number of terms
							System.out.print("Sum till 'n' terms: n = ");
							z = sc.nextLine();
							try {
								// Parse the input for the number of terms 'n' into a Double
								n = Double.parseDouble(z);
								if (n == (int) n) {
									// Calculate the sum of the arithmetic progression using the formula
									S = (n * (2 * a + ((n - 1) * d))) / 2;
									ss = subScript((int) n);
									// Output the result of the sum, handling whether it's an integer or decimal
									if (S == (int) S) System.out.println("S" + ss + " = " + (int) S);
									else System.out.println("S" + ss + " = " + S);
								} else System.out.println("'n' should not be a decimal. It is the number of terms.");
							} catch (NumberFormatException e) {
								System.out.println("Invalid number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid number");
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