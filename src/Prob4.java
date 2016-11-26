import java.util.Scanner;



public class Prob4 {

	public static class Ingredient {
		public String name;
		public double weight;
		public double percent;
		
		public Ingredient(String name, double w, double percent) {
			this.name = name;
			this.weight = w;
			this.percent = percent;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = scn.nextInt();
		
		
		for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = scn.nextInt();
			for(int testCase = 0; testCase < testCases; testCase++) {
				int ing = scn.nextInt();
				int start = scn.nextInt();
				int desired = scn.nextInt();
				
				
				Ingredient[] arr = new Ingredient[ing];
				
				Ingredient main = null;
				
				for (int i = 0; i < ing; i++ ){
					String name = scn.next();
					double weight = scn.nextDouble();
					double percentage = scn.nextDouble();
					
					arr[i] = new Ingredient(name, weight, percentage);
					if(percentage == 100.0) {
						main = arr[i];
					}
				}
				
				double factor = (double) desired / start;
				double mainW = main.weight * factor;
				
				System.out.println("Recipe # "+(testCase+1));

				for (int i = 0; i < ing; i++) {
					System.out.printf(arr[i].name + " %.1f\n",arr[i].percent*mainW/100.0);
				}
				for(int i = 0; i<40; i++){
					System.out.print("-");
					
				}
				System.out.println();
				
				
			}
		}
	}

}
