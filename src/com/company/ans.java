package com.company;

import java.io.*;
import java.util.Scanner;

public class ans {
                    // 0  1  2  3  4  5  6  7
    private int[] s;
    private int[] c;

    private int find(int x) {
        // return value of face if matches with index in array
        if (x == s[x]) { // if number is the index
            return x;
        }
        else {
            //compute find that value and index instead
            return s[x] = find(s[x]);
        }
//        return x == s[x] ? x : (s[x] = find(s[x]));
    }

    /**
     *
     * @param x front facing
     * @param y back facing
     */
    private void union(int x, int y) {
        // go in to 4, find 4, -> s[x] = 4
        // s[y] = 1
        int sx = find(x);
        int sy = find(y);
        if (sx == sy) {
            // increment count collision
            c[sx]++;
        } else {
            // set s[sy] to index of x
            // adding count collisions of y to x values
            s[sy] = sx;
            c[sx] += c[sy];
        }
    }


    private void work() {
        Scanner sc = null;
        // grab input cases
        try {
//            sc = new Scanner(new File("/Users/Joseph/Development/test/src/com/company/in.put.txt"));
            sc = new Scanner(new File("/Users/Joseph/Development/test/src/com/company/simple"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int cases = sc.nextInt(); // concatenated files

        for(int casei=0;casei < cases; casei++) {
            s = new int[200200]; // array of cards
            c = new int[200200];

            int nc = sc.nextInt(); // number of cases
            for (int testCase = 1; testCase <= nc; testCase++) {
                int numberOfCards = sc.nextInt();
                for (int cardIndex = 1; cardIndex <= numberOfCards; cardIndex++) {
                    // fills indices in s from 1 to 2n set as 0 to i to 2n

                    s[cardIndex] = cardIndex;
                    s[cardIndex + numberOfCards] = cardIndex + numberOfCards;
//                    c[cardIndex] = c[cardIndex + numberOfCards] = 0;
                }
                // actually grab values here
                for (int i = 0; i < numberOfCards; i++) {
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    union(p, q);
                }
                boolean ok = true;
                for (int i = numberOfCards + numberOfCards; i > 0; i--) {
                    if (c[find(i)] > 1) {
                        ok = false;
                        break;
                    }
                }
                System.out.println((ok ? "" : "im") + "possible");
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new ans().work();


		long t = System.currentTimeMillis() - startTime;
		System.err.printf("Elapsed time: %02d:%02d:%02d.%03d\n",
				t / 1000 / 3600, ((t / 1000) % 3600) / 60, (t / 1000) % 60,
				t % 1000);
    }

}