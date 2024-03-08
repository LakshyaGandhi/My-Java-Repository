import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Compound_Maker {
	/**
	 * Main method to execute the Compound Maker program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("The Compound Maker");
		while (true) {
			System.out.println("\nEnter a metal to start the program"); // Prompt user to enter a metal
			System.out.println("OR Type 'exit' to quit the program."); // Prompt user to type 'exit' to quit
			Scanner extscan = new Scanner(System.in);
			String ext = extscan.nextLine(); // Read user input
			// For all other user inputs
			if (ext.equals("exit")) { // If user input is 'exit'
				System.exit(0); // Exit the program
			} else {
				String[] metals = {"Cu", "Hg", "Ag", "Hg", "Au", "NH4", "H", "Li", "Na", "K", "Fe", "Sn", "Pt", "Mn", "Pb", "Ba", "Ca", "Mg", "Ni", "Zn", "Al", "As", "Bi", "Cr"};
				String[] nonmetals = {"F", "Br", "Cl", "I", "OH", "NO3", "NO2", "HCO3", "HS", "HSO3", "HSO4", "ClO", "ClO2", "ClO3", "ClO4", "MnO4", "CN", "CH3COO", "AlO2", "O", "(COO)2", "SO4", "SO3", "S", "S2O3", "CO3", "CrO4", "Cr2O7", "SiO3", "SnO3", "ZnO2", "PbO2", "P", "PO3", "PO4", "AsO4", "AsO3", "BO3", "N", "AlO3", "C", "Fe(CN)6", "O2"};
				List<String> metallists = Arrays.asList(metals); // Convert metal array to a list
				List<String> nonmetallists = Arrays.asList(nonmetals); // Convert non-metal array to a list
				if (metallists.contains(ext)) {
					System.out.print("Enter its valency = ");
					Scanner metalscan = new Scanner(System.in);
					String x = metalscan.nextLine();
					try {
						byte metalv = Byte.parseByte(x);
						if (metalv > 0 && metalv <= 4) {
							// Ask for non-metal
							System.out.print("Enter a non-metal = ");
							Scanner nonmetalscan = new Scanner(System.in);
							String nmstring = nonmetalscan.nextLine();
							if (nonmetallists.contains(nmstring)) {
								System.out.print("Enter its valency = ");
								String y = metalscan.nextLine();
								try {
									byte nonmetalv = Byte.parseByte(y); // Parse the user input for non-metal valency to a byte
									if (nonmetalv > 0 && nonmetalv <= 4) {
										// Output compound based on valencies
										if (metalv == nonmetalv) {
											System.out.println(ext + nmstring); // Output compound without brackets
										} else if (nonmetalv == 1) {
											System.out.println(ext + "(" + nmstring + ")" + metalv); // Output compound with non-metal in brackets
										} else if (metalv == 1) {
											System.out.println("(" + ext + ")" + nonmetalv + nmstring); // Output compound with metal in brackets
										} else {
											System.out.println(ext + nonmetalv + "(" + nmstring + ")" + metalv); // Output compound with both metal and non-metal in brackets
										}
									} else {
										System.out.println("Valency must be between 1 and 4; without any sign");
									}
								} catch (NumberFormatException e) {
									System.out.println("Valency must be between 1 and 4; without any sign");
								}
							} else if (metallists.contains(nmstring)) {
								System.out.println("You are supposed to enter a non-metal (not metal).");
							} else {
								System.out.println("Wrong Input!!");
							}
						} else {
							System.out.println("Valency must be between 1 and 4; without any sign");
						}
					} catch (NumberFormatException e) {
						System.out.println("Valency must be between 1 and 4; without any sign");
					}
				} else if (nonmetallists.contains(ext)) {
					System.out.println("You are supposed to enter a metal (not non-metal).");
				} else {
					System.out.println("Wrong Input!!");
				}
			}
		}
	}
}