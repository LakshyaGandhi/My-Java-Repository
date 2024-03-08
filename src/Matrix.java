import java.util.Scanner;

public class Matrix {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Matrix Calculator");
		System.out.println("\nMATRIX A INPUT");
		System.out.print("Enter number of rows: ");
		int rows1 = sc.nextInt();
		System.out.print("Enter number of columns: ");
		int cols1 = sc.nextInt();
		System.out.println("Enter Matrix A Elements:");
		int[][] arr1 = new int[rows1][cols1]; // Create a 2D array to store Matrix A elements
		for (int i = 0; i < rows1; i++) {
			for (int j = 0; j < cols1; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		while (true) {
			System.out.println("MATRIX B INPUT");
			System.out.print("Enter number of rows: ");
			int rows2 = sc.nextInt();
			System.out.print("Enter number of columns: ");
			int cols2 = sc.nextInt();
			System.out.println("Enter Matrix B Elements:");
			int[][] arr2 = new int[rows2][cols2]; // Create a 2D array to store Matrix B elements
			for (int i = 0; i < rows2; i++) {
				for (int j = 0; j < cols2; j++) {
					arr2[i][j] = sc.nextInt();
				}
			}
			System.out.println("Type 1: Addition");
			System.out.println("Type 2: Subtraction");
			System.out.println("Type 3: Multiplication");
			System.out.println("Type 'exit' to quit the program");
			System.out.print("Enter a choice: ");
			sc.nextLine();
			String ex = sc.nextLine();
			String ext = ex.toLowerCase();
			int[][] arr3 = new int[rows1][cols1]; // Create a 2D array to store the result of the operation
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				case "1":
					if (rows1 == rows2 && cols1 == cols2) {
						System.out.println("New Matrix A is(i.e., Solution):");
						// Perform matrix addition
						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < cols1; j++) {
								arr3[i][j] = arr1[i][j] + arr2[i][j];
								System.out.print(arr1[i][j] + arr2[i][j] + " ");
							}
							System.out.println();
						}
						// Array Copy
						for (int i = 0; i < rows1; i++) {
							System.arraycopy(arr3[i], 0, arr1[i], 0, cols1); // Copy the result back to Matrix A
						}
					} else {
						System.out.println("Both the Arrays must be of same order."); // Error message for invalid operation
						System.exit(0);
					}
					break;
				
				case "2":
					if (rows1 == rows2 && cols1 == cols2) {
						System.out.println("New Matrix A is(i.e., Solution):");
						// Perform matrix subtraction
						for (int i = 0; i < rows1; i++) {
							for (int j = 0; j < cols1; j++) {
								arr3[i][j] = arr1[i][j] - arr2[i][j];
								System.out.print(arr1[i][j] - arr2[i][j] + " ");
							}
							System.out.println();
						}
						// Array Copy
						for (int i = 0; i < rows1; i++) {
							System.arraycopy(arr3[i], 0, arr1[i], 0, cols1); // Copy the result back to Matrix A
						}
					} else {
						System.out.println("Both the Arrays must be of same order.");
						System.exit(0);
					}
					break;
				
				case "3":
					if (cols1 == rows2) { // Check if the number of columns in the first matrix is equal to the number of rows in the second matrix
						System.out.println("New Matrix A is(i.e., Solution):");
						for (int i = 0; i < rows1; i++) { // Loop through the rows of the first matrix
							for (int j = 0; j < cols2; j++) { // Loop through the columns of the second matrix
								for (int k = 0; k < cols1; k++) { // Loop through the columns of the first matrix
									arr3[i][j] += arr1[i][k] * arr2[k][j]; // Calculate the product of the two matrices and update the result matrix
								}
								System.out.print(arr3[i][j] + " ");
							}
							System.out.println(); // Move to the next line after printing each row
						}
					} else {
						System.out.println("Both the Arrays must be of same order.");
						System.exit(0);
					}
					break;
				
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}