import java.util.*;

public class Prob1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int inputFiles = scn.nextInt();

		for (int inputFile = 0; inputFile < inputFiles; inputFile++) {
			int testCases = scn.nextInt();
			for (int testCase = 0; testCase < testCases; testCase++) {
				int n = scn.nextInt();
				int max = 0;
				int sum = 0;
				TreeMap<Integer, Integer> map = new TreeMap<>();
				ArrayList<Integer> arrList = new ArrayList<>();
				for (int i = 0; i < n; i++) {
					int votes = scn.nextInt();

					sum += votes;
					arrList.add(votes);
					max = Math.max(votes, max);
					Integer people = map.get(votes);
					if (people == null) {
						map.put(votes, 1);
					} else {
						map.put(votes, people + 1);
					}

				}

				if (map.get(max) > 1) {
					System.out.println("no winner");
				} else {
					int maxVotes = arrList.indexOf(max) + 1;
					if (max * 2 > sum) {
						System.out.println("majority winner " + maxVotes);

					} else {
						System.out.println("minority winner " + maxVotes);
					}

				}
			}

		}
	}

}
