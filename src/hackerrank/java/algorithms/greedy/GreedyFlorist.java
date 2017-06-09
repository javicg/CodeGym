package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int minimumCost = getMinimumCost(n, k, c);
        System.out.println(minimumCost);
    }

    private static int getMinimumCost(int n, int k, int[] c){
        if (n <= k) {
            return Arrays.stream(c).sum();
        } else {
            Arrays.sort(c);
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int factor = i / k + 1;
                sum += factor * c[n-i-1];
            }
            return sum;
        }
    }
}
