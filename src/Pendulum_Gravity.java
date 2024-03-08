import java.util.Scanner;

public class Pendulum_Gravity {
	/**
	 * Main method to execute the program.
	 * The program prompts the user to input the length of a pendulum string
	 * and two time trial values, calculates the gravity, and displays the result.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Pendulum Gravity Finder");
		while (true) {
			System.out.println("\nEnter the length of the string of a pendulum");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {
				System.exit(0);
			} else {
				try {
					double length = Double.parseDouble(ex);
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter time(trial 1), seconds = ");
					String x1 = sc.nextLine();
					try {
						double time1 = Double.parseDouble(x1);
						System.out.print("Enter time(trial 2), seconds = ");
						String x2 = sc.nextLine();
						try {
							double time2 = Double.parseDouble(x2);
							// Calculate the time period
							double time_period = (time1 + time2) / 40;
							// Calculate gravity
							double gravity = (4 * Math.PI * Math.PI * length) / (time_period * time_period);
							System.out.println("The gravity is = " + gravity + " m/s2");
						} catch (NumberFormatException e) {
							System.out.println(x2 + " is not a valid time value");
						}
					} catch (NumberFormatException e) {
						System.out.println(x1 + " is not a valid time value");
					}
				} catch (NumberFormatException e) {
					System.out.println(ext + " is not a valid length value");
				}
			}
		}
	}
}