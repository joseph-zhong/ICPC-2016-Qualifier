import java.util.Scanner;

public class Prob9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = scn.nextInt();
		
		
		for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = scn.nextInt();
			for(int testCase = 0; testCase < testCases; testCase++) {
				int r = scn.nextInt();
				int c = scn.nextInt();
				int[][] arr = new int[r][c];
				
				for(int i = 0; i < r; i++) {
					String row = scn.next();
					for(int j = 0; j < c; j++) {
						arr[i][j] = Integer.valueOf(String.valueOf(row.charAt(j)));
					}
				}
				
				char[][] out = new char[r][c];
				if (!test(r, c, out, arr)){
					System.out.println("impossible");
				}
				else {
					//printing output 
					for (int i = 0; i < r; i++ ){
						System.out.println(new String(out[i]));
					}
				}
				
				
				
				
				
				
				for(int i = 0; i < 10; i++ ){ 
					System.out.print("-");					
				}
				System.out.println();
			}

		}
	}
	
	public static boolean test (int r, int c, char[][] out, int[][] arr) {
	
		for (int i = 0; i < r; i ++) { // row
			for ( int j = 0; j < c; j++) { // column
				if(arr[i][j] == 0) {
					out[i][j] = 'N';
				} // sets everything N when 0
				else {
					boolean seen_r = false;
					boolean seen_c = false;
					for (int k = 0; k < r; k ++) { // col checking
						if (k != i && arr[k][j] == 1) {
							seen_c = true;
						}
					}
					
					for (int k = 0; k < c; k ++) { // row checking
						if (k != j && arr[i][k] == 1) {
							seen_r = true;
						}
					}
					
					if (seen_r && seen_c) {
						out[i][j] = 'I';
					}
					else if ((seen_r && !seen_c) || (!seen_r && seen_c)) {
						out[i][j] = 'P';
					}
					else if (!seen_r && !seen_c) {
						return false;
					}						
				}
			}
		}
		return true;
	}

}
