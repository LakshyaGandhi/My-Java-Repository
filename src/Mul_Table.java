import java.util.Scanner;

/**
 * This program generates multiplication tables using two different looping techniques:
 * 1. Do-While Loop
 * 2. For Loop
 *
 * The user is prompted to input a number for which they want to generate the multiplication table.
 * Then, the user enters how much the number should be multiplied.
 * The program then calculates and displays the multiplication table using the chosen looping technique.
 */
class do_whileLoop_Mul_Table {
	public static void main(String[] args) {
		System.out.println("Table Number");
		while (true) {
			System.out.println("\nWrite table number");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
					
				default:
					try {
						Scanner sc = new Scanner(System.in);
						long num = Long.parseLong(ex);
						System.out.println("Till how much it should multiply? ");
						String z = sc.nextLine();
						try {
							long mul = Long.parseLong(z);
							long i = 1;
							do {
								System.out.println(num + " * " + i + " = " + num * i);
								i++;
							} while (i <= mul);
						} catch (NumberFormatException e) {
							System.out.println(z + " is not a valid number");
						}
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid number");
					}
			}
		}
	}
}

/**
 * This program generates multiplication tables using two different looping techniques:
 * 1. Do-While Loop
 * 2. For Loop
 *
 * The user is prompted to input a number for which they want to generate the multiplication table.
 * Then, the user enters how much the number should be multiplied.
 * The program then calculates and displays the multiplication table using the chosen looping technique.
 */
class forLoop_Mul_Table {
	public static void main(String[] args) {
		System.out.println("Table Number");
		while (true) {
			System.out.println("\nWrite table number");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
					
				default:
					try {
						Scanner sc = new Scanner(System.in);
						long num = Long.parseLong(ex);
						System.out.println("Till how much it should multiply? ");
						String z = sc.nextLine();
						try {
							long mul = Long.parseLong(z);
							for (long i = 1; i <= mul; i++) {
								System.out.println(num + " x " + i + " = " + num * i);
							}
						} catch (NumberFormatException e) {
							System.out.println(z + " is not a valid number");
						}
					} catch (NumberFormatException e) {
						System.out.println(ex + " is not a valid number");
					}
			}
		}
	}
}