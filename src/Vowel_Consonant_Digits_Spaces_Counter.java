import java.util.Scanner;

public class Vowel_Consonant_Digits_Spaces_Counter {
	/**
	 * Counts the number of vowels, consonants, digits, and spaces in the input text.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Vowel, Consonant, Digits & Spaces Counter");
		while (true) {
			System.out.println("\nEnter a text");
			System.out.println("OR Type 'exit' to quit the program");
			Scanner extscan = new Scanner(System.in);
			String ex = extscan.nextLine();
			String ext = ex.toLowerCase();
			if (ext.equals("exit")) {
				System.exit(0);
			} else {// Converting input text to lowercase for uniformity
				ex = ex.toLowerCase();
				int vowels = 0, consonants = 0, digits = 0, spaces = 0;
				// Iterating through each character of the input text
				for (int x = 0; x < ex.length(); ++ x) {
					char ch = ex.charAt(x);
					// Checking if the character is a vowel
					if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
						++ vowels;
					} else if ((ch >= 'a' && ch <= 'z')) {
						// Checking if the character is a consonant
						++ consonants;
					} else if (ch >= '0' && ch <= '9') {
						// Checking if the character is a digit
						++ digits;
					} else if (ch == ' ') {
						// Checking if the character is a space
						++ spaces;
					}
				}
				// Printing the counts of vowels, consonants, digits, and spaces
				System.out.println("Vowels: " + vowels);
				System.out.println("Consonants: " + consonants);
				System.out.println("Digits: " + digits);
				System.out.println("White spaces: " + spaces);
			}
		}
	}
}