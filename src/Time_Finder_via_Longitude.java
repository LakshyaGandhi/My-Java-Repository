import java.util.Scanner;

/**
 * Time Finder via Longitude
 * This program calculates the time based on the longitude provided by the user.
 * It converts the longitude into hours and minutes to determine the time.
 */
public class Time_Finder_via_Longitude {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Time Finder via Longitude");
		while (true) {
			// User input for longitude or exit option
			System.out.println("\nEnter a longitude to start the program");
			System.out.println("OR Type 'exit' to quit the program.");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {
				System.exit(0);
			} else {
				try {
					float num = Float.parseFloat(ex);
					float hr = (num * 4) / 60;
					float rem = (num * 4) % 60;
					if (num <= 360) {
						int hrr = (int) hr;
						int rem1 = (int) rem;
						int westhrr = 11 - hrr, westrem1 = 60 - rem1;
						if (num < 180) {
							// East side time
							System.out.println("The time is " + hrr + "hr : " + rem1 + "min PM for East");
							// West side time
							System.out.println("The time is " + westhrr + "hr : " + westrem1 + "min AM for West");
						} else if (num == 180) {
							// At 180 degrees
							System.out.println("The time is 12hr : 00min AM for East");
							System.out.println("The time is 12hr : 00min AM for West");
						} else {
							// Longitude greater than 180
							int _12hr_format = hrr - 12;
							// East side time
							System.out.println("The time is " + _12hr_format + "hr : " + rem1 + "min AM for East");
							// West side time
							System.out.println("The time is " + _12hr_format + "hr : " + rem1 + "min PM for West");
						}
					} else {
						// Longitude validation
						System.out.println("The longitude should be less than or equal to 360");
					}
				} catch (NumberFormatException e) {
					// Invalid input handling
					System.out.println(ex + " is not a valid longitude");
				}
			}
		}
	}
}