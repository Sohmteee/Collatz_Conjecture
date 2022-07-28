
import java.util.Scanner;

public class Main extends Solve {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Collatz Conjecture");
		System.out.println();
		
		do {
			System.out.print("Input the positive integer:  ");
			num = sc.nextInt();
			
			if (num < 1) {
				System.out.println();
				System.out.println("It must be a positive integer");
			}
			
		} while (num < 1);
		
		n = num;
		System.out.println();
		System.out.print(num);
		
		while (num > 1) {
			if (isEven(num)) {
				System.out.println(" (Since number is even, we divide by two)");
				System.out.println();
				System.out.print(num + " / 2 = " + calc(num));

			} else {
				System.out.println(" (Since number is odd, we multiply by three and add one)");
				System.out.println();
				System.out.print("(3 x " + num + ") + 1 = " + calc(num));
			}
			num = calc(num);

			count++;
		}
		
		System.out.println();
		System.out.println();
		System.out.println("It took " + count + " steps to get to 1");
		System.out.println();
		
		graph();
		sc.close();
	}
}