import java.util.Scanner;

public class Prob5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = scn.nextInt();
		
		
		for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = scn.nextInt();
			for(int testCase = 0; testCase < testCases; testCase++) {
				int x_c, y_c, z_c, r_c, v_x_c, v_y_c, v_z_c;
				int x_j, y_j, z_j, r_j, v_x_j, v_y_j, v_z_j;
				// craft
				x_c = scn.nextInt();
				y_c = scn.nextInt();
				z_c = scn.nextInt();
				r_c = scn.nextInt();
				v_x_c = scn.nextInt();
				v_y_c = scn.nextInt();
				v_z_c = scn.nextInt();
				
				// junk
				x_j = scn.nextInt();
				y_j = scn.nextInt();
				z_j = scn.nextInt();
				r_j = scn.nextInt();
				v_x_j = scn.nextInt();
				v_y_j = scn.nextInt();
				v_z_j = scn.nextInt();
				
				// velocity vectors
				int v_x = v_x_c - v_x_j;
				int v_y = v_y_c - v_y_j;
				int v_z = v_z_c - v_z_j;
				
				// total distance until "collision"
				int r = r_c + r_j;
				
				// centers of each object
				int x = x_c - x_j;
				int y = y_c - y_j;
				int z = z_c - z_j;
				
				// quadratic formula
				int a = v_x * v_x + v_y * v_y + v_z * v_z;
				int b = 2 * (x * v_x + y * v_y + z * v_z);
				int c = -(r * r) + x * x + y * y + z * z;
				int discr = b * b - 4 * a * c;
				if (a == 0) {
					System.out.print("No collision\n");
				}
				else if (discr < 0) {
					System.out.print("No collision\n");					
				}
				
				/** 
				 * Edge Cases that have been accounted for
				 * 
				 * 
				 * 
				 * */
				
				else {
					double t1 = (-b - Math.sqrt(discr)) / (2 * a);
					double t2 = (-b + Math.sqrt(discr)) / (2 * a);
					if (t1 < 0 && t2 < 0) {
						System.out.println("No collision");
					}
					else if (t1 < 0 && t2 > 0) { // doesn't actually do anything because vector motion
						System.out.printf("%.3f\n", t2);
					}
					else if (t1 > 0 && t2 > 0) {
						System.out.printf("%.3f\n", Math.min(t1, t2));
					}
					else if (t1 > 0 && t2 < 0) { // doesn't actually do anything because vector motion
						System.out.printf("%.3f\n", t1);
					}
					else if (t1 == 0 || t2 == 0) {
						System.out.println("No collision");						
					}
				}
			}
			
			//System.out.println("No collision");
		}
		
		
	}


}
