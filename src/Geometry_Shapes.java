import java.util.Scanner;

/**
 * This program calculates the area and perimeter of various geometric shapes
 * based on user input of dimensions.
 */
public class Geometry_Shapes {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Geometry Shapes Calculator");
		System.out.println("NOTE: ALL UNITS SHOULD BE SAME, That is, all should be either cm or m or km.....");
		while (true) {
			// Display available shapes and instructions
			System.out.println("\nType 'square' for shape");
			System.out.println("Type 'rectangle' for shape");
			System.out.println("Type 'triangle' for shape");
			System.out.println("Type 'circle' for shape");
			System.out.println("Type 'exit' to quit the program");
			System.out.print("Enter your choice = ");
			Scanner sc = new Scanner(System.in);
			String ex = sc.nextLine();
			String ext = ex.toLowerCase();
			switch (ext) {
				case "exit":
					System.exit(0);
					break;
				
				case "square":
					// Calculate area and perimeter of square
					System.out.print("Enter length or breadth = "); //property of square: size of  length = size of breadth
					Scanner square = new Scanner(System.in);
					String w = square.nextLine();
					try {
						double lorb = Double.parseDouble(w);
						double sqrarea = lorb * lorb; // Area of square formula: side length * side length
						double sqrperimeter = 4 * lorb; // Perimeter of square formula: 4 * side length
						System.out.println("->The Area of Square " + lorb + " is = " + sqrarea + " cm sq.");
						System.out.println("->The Perimeter of Square " + lorb + " is = " + sqrperimeter + " cm.");
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
					break;
				
				case "rectangle":
					// Calculate area and perimeter of rectangle
					System.out.print("Enter length = ");
					Scanner rectangle = new Scanner(System.in);
					String x = rectangle.nextLine();
					try {
						double lofr = Double.parseDouble(x);
						System.out.print("Enter breadth = ");
						String x1 = rectangle.nextLine();
						try {
							double bofr = Double.parseDouble(x1);
							double recarea = lofr * bofr; // Area of rectangle formula: length * breadth
							double recperimeter = 2 * (lofr + bofr); // Perimeter of rectangle formula: 2 * (length + breadth)
							System.out.println("->The Area of Rectangle " + lofr + " and " + bofr + " is = " + recarea + " cm sq.");
							System.out.println("->The Perimeter of Rectangle " + lofr + " and " + bofr + " is = " + recperimeter + " cm.");
						} catch (NumberFormatException e) {
							System.out.println("Invalid Number");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
					break;
				
				case "triangle":
					// Calculate perimeter of triangle
					System.out.print("Enter length of side 'a' = ");
					Scanner triangle = new Scanner(System.in);
					String y = triangle.nextLine();
					try {
						double sidea = Double.parseDouble(y);
						System.out.print("Enter length of side 'b' = ");
						String y1 = triangle.nextLine();
						try {
							double sideb = Double.parseDouble(y1);
							System.out.print("Enter length of side 'c' = ");
							String y2 = triangle.nextLine();
							try {
								double sidec = Double.parseDouble(y2);
								if (sidea + sideb + sidec > 180) { //Basic rule of triangles: Sum of all sides of a triangle should not be greater than 180°
									System.out.println("Invalid Values. The Sum of all sides of a triangle is more than 180°");
								} else {
									double triperimeter = sidea + sideb + sidec; // Perimeter of triangle formula: side a + side b + side c
									System.out.println("->The Perimeter of Triangle " + sidea + " + " + sideb + " + " + sidec + " is = " + triperimeter + " cm.");
									break;
								}
							} catch (NumberFormatException e) {
								System.out.println("Invalid Number");
							}
						} catch (NumberFormatException e) {
							System.out.println("Invalid Number");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
					break;
				
				case "circle":
					// Calculate area and perimeter of circle
					System.out.print("Enter radius = ");
					String z = sc.nextLine();
					try {
						double r = Double.parseDouble(z);
						double circlearea = Math.PI * r * r; // Area of circle formula: π * radius * radius
						double circleperi = 2 * Math.PI * r; //Circumference of circle formula: 2 * π * radius
						System.out.println("->The Area of Circle " + r + " is = " + circlearea + " cm sq.");
						System.out.println("->The Circumference of Circle " + r + " is = " + circleperi + " cm");
					} catch (NumberFormatException e) {
						System.out.println("Invalid Number");
					}
					break;
				
				default:
					System.out.println("Invalid Input");
			}
		}
	}
}