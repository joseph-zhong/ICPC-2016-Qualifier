import java.util.*;

public class Prob10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = scn.nextInt();
		
		
		for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = scn.nextInt();
			for(int testCase = 0; testCase < testCases; testCase++) {
				
				int num = scn.nextInt();
				
				Set<String> s = new HashSet<>();
				for (int i = 0; i < num; i++){
					s.add(scn.next());
				}
				
				System.out.println(s.size());
				
			}
			
			
		}
	}

}
