import java.util.Scanner;

public class Pythagoras_Theorem {
	/**
	 * Prints the values of hypotenuse, perpendicular, and base.
	 *
	 * @param hypotenuse    The length of the hypotenuse.
	 * @param perpendicular The length of the perpendicular/opposite side.
	 * @param base          The length of the base/adjacent side.
	 */
	public static void printSolution(float hypotenuse, float perpendicular, float base) {
		System.out.println("Hypotenuse = " + hypotenuse + " units");
		System.out.println("Perpendicular/Opposite = " + perpendicular + " units");
		System.out.println("Base/Adjacent = " + base + " units");
	}
	
	/**
	 * Main method to execute the program.
	 * It provides options for the user to find hypotenuse, perpendicular, or base of a right triangle.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Pythagoras Theorem");
		while (true) {
			System.out.println("\nEnter an option:");
			System.out.println("Type 1: Find Hypotenuse");
			System.out.println("Type 2: Find Perpendicular/Opposite");
			System.out.println("Type 3: Find Base/Adjacent");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				case "1":
					// Finding hypotenuse
					System.out.print("Enter opposite/perpendicular = ");
					String x1 = extscan.nextLine();
					try {
						float perpendicular = Float.parseFloat(x1);
						System.out.print("Enter base/adjacent = ");
						String x2 = extscan.nextLine();
						try {
							float base = Float.parseFloat(x2);
							float hypotenuse = (float) Math.sqrt((perpendicular * perpendicular) + (base * base));
							printSolution(hypotenuse, perpendicular, base);
						} catch (NumberFormatException e) {
							System.out.println("Invalid Value");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Value");
					}
					break;
				
				case "2":
					// Finding perpendicular
					System.out.print("Enter adjacent/base = ");
					String y1 = extscan.nextLine();
					try {
						float base = Float.parseFloat(y1);
						System.out.print("Enter hypotenuse = ");
						String y2 = extscan.nextLine();
						try {
							float hypotenuse = Float.parseFloat(y2);
							float perpendicular = (float) Math.sqrt((hypotenuse * hypotenuse) - (base * base));
							printSolution(hypotenuse, perpendicular, base);
						} catch (NumberFormatException e) {
							System.out.println("Invalid Value");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Value");
					}
					break;
				
				case "3":
					// Finding base
					System.out.print("Enter opposite/perpendicular = ");
					String z1 = extscan.nextLine();
					try {
						float perpendicular = Float.parseFloat(z1);
						System.out.print("Enter hypotenuse = ");
						String z2 = extscan.nextLine();
						try {
							float hypotenuse = Float.parseFloat(z2);
							float base = (float) Math.sqrt((hypotenuse * hypotenuse) - (perpendicular * perpendicular));
							printSolution(hypotenuse, perpendicular, base);
						} catch (NumberFormatException e) {
							System.out.println("Invalid Value");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Value");
					}
					break;
				
				default:
					System.out.println("Invalid Input");
					break;
			}
		}
	}
}