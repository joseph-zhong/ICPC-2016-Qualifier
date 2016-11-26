package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;



public class Prob2 {
    private static final ForkJoinPool POOL = new ForkJoinPool();

    private static class ParallelExplore extends RecursiveTask<Boolean> {

        private Set<Integer> set;
        private int n;
        private int[][] arr;

        /**
         *
         * @param set the individual set of card values to explore
         * @param n index of where we're currently exploring
         * @param arr the cards
         */
        public ParallelExplore(Set<Integer> set, int n, int[][] arr) {
            this.set = new HashSet<>(set);
            this.n = n;
            this.arr = arr;
        }

        @Override
        protected Boolean compute() {
            /**
             * Create a new thread for choosing card face up
             *  Another thread will be for choosing card face down
             *
             *
             */
            if (n == arr.length) {
                return true;
            }
            if (set.contains(arr[n][0])) {
                if (set.contains(arr[n][1])) {
                    return false;
                } else {
                    set.add(arr[n][1]);
                    ParallelExplore thread = new ParallelExplore(set, n + 1, arr);

                    thread.fork();
                    return thread.join();
//                    return thread.compute(); // this stack overflow
                }
            }
            else {
                if (set.contains(arr[n][1])) {
                    set.add(arr[n][0]);
                    ParallelExplore thread = new ParallelExplore(set, n + 1, arr);

                    thread.fork();
                    return thread.join();
//                    return thread.compute();
                } else {
                    set.add(arr[n][0]);
                    ParallelExplore thread1 = new ParallelExplore(set, n + 1, arr);
                    set.remove(arr[n][0]);
                    set.add(arr[n][1]);
                    ParallelExplore thread2 = new ParallelExplore(set, n + 1, arr);
                    thread1.fork();
                    thread2.fork();
//                    return thread.join();


//                    return thread2.compute() || thread1.join();
                    return thread2.join() || thread1.join();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        try {
            scn = new Scanner(new File("/Users/Joseph/Development/test/src/com/company/in.put.txt"));
//            scn = new Scanner(new File("/Users/Joseph/Development/test/src/com/company/in_new"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int inputFiles = scn.nextInt();


        for(int inputFile = 0; inputFile < inputFiles; inputFile++) {
            long startTime = System.currentTimeMillis();
            int testCases = scn.nextInt();


            // stack overflow

            for (int testCase = 0; testCase < testCases; testCase++) {
                int n = scn.nextInt(); // number of cards to handle
                int[][] arr = new int[n][2];

                for (int i = 0; i < n; i++) {
                    arr[i][0] = scn.nextInt(); // face up card values
                    arr[i][1] = scn.nextInt(); // face down card values
                }
//                System.out.println(Arrays.toString(arr));
//                System.out.println(arr.length);
                HashSet<Integer> set = new HashSet<>();
                int index = 0;

                // call our ParallelExplore
                ParallelExplore pe = new ParallelExplore(set, index, arr);
                if (POOL.invoke(pe)) {
                    System.out.println("possible");
                } else {
                    System.out.println("impossible");
                }

            }
            long t = System.currentTimeMillis() - startTime;
            System.err.printf("Elapsed time: %02d:%02d:%02d.%03d\n",
                    t / 1000 / 3600, ((t / 1000) % 3600) / 60, (t / 1000) % 60,
                    t % 1000);
        }
    }
}