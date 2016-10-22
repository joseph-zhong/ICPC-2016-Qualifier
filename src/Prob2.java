import java.util.*;

public class Prob2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = scn.nextInt();

		
		for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = scn.nextInt();
		
			
			
			// backtrace timeout
			
			for(int testCase = 0; testCase < testCases; testCase++) {
				int n = scn.nextInt();
				int[][] arr = new int[n][2];
				
				for (int i = 0; i < n; i++ ){
					arr[i][0] = scn.nextInt();
					arr[i][1] = scn.nextInt();
				}
				
				Stack<Integer> stack = new Stack<Integer>();
				
				Set<Integer> set = new HashSet<Integer>();
				set.add(arr[0][0]);
				stack.push(0);
				if (explore(stack, set, n, arr)) {
					System.out.println("possible");					
				}
				else {
					System.out.println("impossible");
				}
				
				
			}
		}
			
			
	}
	
	public static boolean  explore(Stack<Integer> stack, Set<Integer> set, int n, int[][] arr){
		if(stack.isEmpty()) {
			return false;
		}
		if(stack.size() == n) {
			return true;
		}
		else {
			int a = arr[stack.size()][0];
			if (set.contains(a)) {
				a = arr[stack.size()][1];	
				if (set.contains(a)) {
					while(!stack.isEmpty() && stack.peek() == 1) {
						stack.pop();
					}
				}
				else {
					stack.push(1);
					set.add(a);
					return explore(stack, set, n, arr);
				}
			}
			else  { // not contained at first
				stack.push(0);
				set.add(a);
				return explore(stack, set, n, arr);
			}
		}
		
		return false;
	}
	

	
	
}
