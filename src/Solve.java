
import java.util.Scanner;

public class Solve {
	public static int num = 0, nextNumber = 0, count = 0, n;
	
	public static boolean isEven(int number) { //creating a method to find out if a given integer is even or odd
		if (number % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int calc(int number) { //creating a method to run some calculations based on the Collatz Conjecture
		if (isEven(number)) {
			nextNumber = number / 2;
		} else {
			nextNumber = (number * 3) + 1;
		}
		return nextNumber;
	}
	
	public static void graph() { //a method to plot the points on a graph based on the above calculations
		System.out.println("\n===============================");
		System.out.println("       For the graph");
		System.out.println("===============================\n");
		
		int c = count + 1, yMin = 0, yMax = 0, j = 0, 
		bool = 1; //initialising a variable that we're going to use to find out the minimum and maximum values of y
		int[] yValues = new int[c], xValues = new int[c];
		
		while (j < c) {
			yValues[j] = n;
			if (bool == 1) { //this is executed only once in the program cos bool will be changed to 0 immediately after this block of code is executed
				yMin = yValues[j];
				yMax = yValues[j]; //yMin and yMax are set to be the first value of yValues. From this, finding the actual min and max values will be easier as you'll see below
			} else {
				if (yValues[j] < yMin) {
					yMin = yValues[j]; // whenever a new value is being analysed and it's less than the previous yMin, it is set as the new yMin value
				} else if (yValues[j] > yMax) {
					yMax = yValues[j]; //the same goes for the yMax variable...
				}
			}
			
			xValues[j] = (j + 1);
			n = calc(n);
			j++;
			
			if (bool == 1) {
				bool = 0; //bool is set to 0 for the rest of the program
			}
		}
		System.out.print("Values of y = ");
		for (int i = 0; i < c; i++) { //block of code to print out the values of y
				if ((i == c - 2)) {
					System.out.print(yValues[i] + " and ");
				} else if (i == c - 1) {
					System.out.print(yValues[i]);
				} else {
					System.out.print(yValues[i] + ", ");
				}
			
		}
		
		System.out.println("\n\nMinimum value of y = " + yMin);
		System.out.println("Maximum value of y = " + yMax + "\n");
		System.out.println("c = " + c);
		System.out.println("\n");
		
		int C;
		
		if (count < 30) {
			
			//plotting the points on the console... (this is the part that took most of my time while I was on this project even though it was just 10 lines)
			//the same way our hands move from left to right and up to down when we're writing, the code below plots the points in the exact same way
			//for example, if there is a point (5,3)
			//when it is on line 3 (counting from down to up),it'll search horizontally, point by point
			// until it reaches the fifth one where it'll mark an asterisk representing the point.
			
			for (int y = yMax; y > 0; y--) { //for each row from up to down, do the following...
				for (int i = 0; i < c; i++) { //for each column in the current row from left to right, do the following...
					C = yValues[i];
					if (y == C) {
						System.out.print(" *(" + C + ") "); //it marks an asterisk with the yValue in brackets beside it
					} else {
						System.out.print("      ");
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("It took more than 30 steps.");
			System.out.print("Do you still wish to display the graph? (y/n): ");
			Scanner sc = new Scanner(System.in);
			String plotGraph = sc.next();
			char plotG = plotGraph.charAt(0);
			
			if (plotG == 'y') { //plot graph anyway
				for (int y = yMax; y > 0; y--) {
					for (int i = 0; i < c; i++) {
						C = yValues[i];
						if (y == C) {
							System.out.print(" *(" + C + ") ");
						} else {
							System.out.print("      ");
						}
					}
					System.out.println();
				}
			} else if (plotG == 'n') {
				System.out.println("You made the right choice lol");
			} else {
				System.out.println("Invalid input. Buh-bye!");
			}
		}
	}
}