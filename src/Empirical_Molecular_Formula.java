import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Empirical_Molecular_Formula {
	/**
	 * Main method to execute the program.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Empirical & Molecular Formula Finder");
		System.out.println("Note: Molecular Wt = 2 * Vapour Density\n");
		System.out.println("Type any word to quit the program OR");
		System.out.print("Enter number of elements: ");
		
		// User input for the number of elements
		String a = sc.nextLine();
		try {
			int size = Integer.parseInt(a);
			String[] ele = new String[size];
			double[] perc = new double[size];
			double[] atwt = new double[size];
			double[] no_atoms = new double[size];
			
			// Create an HTML table with font size adjustments
			StringBuilder tableHTML = new StringBuilder("<html><head><style>" + "table { width: 100%; border-collapse: collapse; border-radius: 18px; overflow: hidden; }" + "table, th, td { border: 1px solid black; }" + "th { background-color: #36304a; color: white; }" + "tr:nth-child(even) { background-color: #f2f2f2; }" + "</style></head><body>" + "<table>" + "<tr><th colspan='5'><font size='10'><b>Empirical & Molecular Formula Finder</b></font></th></tr>" + "<tr><th><font size='8'>Element</font></th><th><font size='8'>% Composition</font></th><th><font size='8'>Atomic Mass</font></th><th><font size='8'>Atomic Ratio</font></th><th><font size='8'>Simplest Ratio</font></th></tr>");
			
			// Input
			System.out.print("Enter the elements symbol simultaneously:\n");
			for (int i = 0; i < size; i++) {
				ele[i] = sc.next();
			}
			
			// % composition
			double flag = 0;
			for (int i = 0; i < size; i++) {
				System.out.print("Enter % composition for element " + ele[i] + ": ");
				perc[i] = sc.nextDouble();
				flag += perc[i];
			}
			
			if (Math.round(flag) == 100) {
				System.out.println();
				//atwt
				for (int i = 0; i < size; i++) {
					System.out.print("Enter atomic weight for element " + ele[i] + ": ");
					atwt[i] = sc.nextDouble();
				}
				System.out.print("Enter molecular weight: ");
				sc.nextLine();
				String b = sc.nextLine();
				try {
					double mwt = Double.parseDouble(b);
					// Relative no of atoms
					for (int i = 0; i < size; i++) {
						no_atoms[i] = perc[i] / atwt[i];
					}
					
					// Smallest no of atoms for ratio 1
					double[] sorted_no_atoms = new double[size];
					System.arraycopy(no_atoms, 0, sorted_no_atoms, 0, size);
					Arrays.sort(sorted_no_atoms);
					
					// Find simplest ratio
					double[] ratio_s = new double[size];
					for (int i = 0; i < size; i++) {
						ratio_s[i] = no_atoms[i] / sorted_no_atoms[0];
						if (ratio_s[i] <= (int) ratio_s[i] + 0.4) ratio_s[i] = Math.floor(ratio_s[i]);
						else if (ratio_s[i] >= (int) ratio_s[i] + 0.6) ratio_s[i] = Math.ceil(ratio_s[i]);
						else ratio_s[i] = (int) ratio_s[i] + 0.5;
					}
					
					// Finding n
					double ewt = 0;
					for (int i = 0; i < size; i++)
						ewt += atwt[i] * ratio_s[i];
					double n = mwt / ewt;
					
					// Add data to the HTML table with 3 decimal precision
					for (int i = 0; i < size; i++) {
						tableHTML.append("<tr><td><font size='6'>").append(ele[i]).append("</font></td><td><font size='6'>").append(String.format("%.3f", perc[i])).append("</font></td><td><font size='6'>").append(atwt[i]).append("</font></td><td><font size='6'>").append(String.format("%.3f", no_atoms[i])).append("</font></td><td><font size='6'>").append(String.format("%.3f", ratio_s[i])).append("</font></td></tr>");
					}
					
					tableHTML.append("</table><br/>").append("<font size='6'><b>n = ").append(String.format("%.3f", n)).append("</b></font><br/><br/>").append("<font size='6'><b>Empirical formula:</b></font><br/>");
					for (int i = 0; i < size; i++) {
						if ((int) ratio_s[i] != 1)
							tableHTML.append("<font size='6'>").append(ele[i]).append((int) ratio_s[i]).append("</font> ");
						else tableHTML.append("<font size='6'>").append(ele[i]).append("</font> ");
					}
					tableHTML.append("<br/><font size='6'><b>Molecular formula:</b></font><br/>");
					for (int i = 0; i < size; i++) {
						if ((int) n * (int) ratio_s[i] != 1)
							tableHTML.append("<font size='6'>").append(ele[i]).append(((int) n * (int) ratio_s[i])).append("</font> ");
						else tableHTML.append("<font size='6'>").append(ele[i]).append("</font> ");
					}
					
					// Display the HTML content in a frame
					JFrame tabbedFrame = new JFrame("Empirical & Molecular Formula");
					tabbedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					tabbedFrame.setSize(800, 600); // Adjust frame size as needed
					JPanel panel = new JPanel(new BorderLayout());
					JEditorPane editorPane = new JEditorPane("text/html", tableHTML.toString());
					editorPane.setEditable(false);
					
					// Create a JScrollPane with horizontal scrollbar policy
					JScrollPane scrollPane = new JScrollPane(editorPane);
					scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					
					panel.add(scrollPane, BorderLayout.CENTER);
					tabbedFrame.add(panel);
					tabbedFrame.setVisible(true);
					
				} catch (NumberFormatException e) {
					System.out.println("Invalid value entered");
				}
			} else System.out.println("The Percentage composition must be 100%.");
		} catch (NumberFormatException e) {
			System.out.println(a + " is not a valid value");
		}
	}
}