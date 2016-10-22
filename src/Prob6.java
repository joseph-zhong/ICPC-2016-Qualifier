import java.util.*;

public class Prob6 {
	
	public static class Person implements Comparable<Person>{ 
		public String name;
		public double val;
		
		public Person(String name, double val) {
			this.name = name;
			this.val = val;
		}
		
		@Override public int compareTo(Person o) {
			if (this.val != o.val){
				return Double.compare(o.val, this.val);
			}
			else {
				return this.name.compareTo(o.name);
			}
			
		}
		
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = Integer.valueOf(scn.nextLine());
		
		
		
		for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = Integer.valueOf(scn.nextLine());
			for(int testCase = 0; testCase < testCases; testCase++) {
				int n = Integer.valueOf(scn.nextLine());
				ArrayList<Person> list = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					String str = scn.nextLine();
					String[] line = str.split(":");
					String parent = line[0];
					String cls = line[1];
					String upper = cls.split(" ")[1];
					String[] uppers = upper.split("-");
					double val = 0;
					double level = 0;
					for (int j = uppers.length - 1; j >= 0; j--) {						
						if(uppers[j].equals("upper")) {
							val += 1.0 * Math.pow(0.1, level);
						}
						else if(uppers[j].equals("middle")) {
//							val += 5.0 * Math.pow(0.1, level); // do nothing!
						}
						else if(uppers[j].equals("lower")) {
							val -= 1.0 * Math.pow(0.1, level);
						}
						level += 1;
					}
									  
					list.add(new Person(parent, val));
					
				}
				Collections.sort(list);
				for (Person p : list) {
					System.out.println(p.name);					
				}
				for (int i = 0; i < 30; i++) {
					System.out.print("=");
					
				}
				System.out.print("\n");
			}
			
			
		}
	}


}
