import java.util.*;
public class Practice {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = scn.nextInt();
		
		
		for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = scn.nextInt();
			for(int testCase = 0; testCase < testCases; testCase++) {
				int a = scn.nextInt();
				System.out.println("The square of " + a + " is " + a * a + ".");
			}
			
			
		}
	}

}
