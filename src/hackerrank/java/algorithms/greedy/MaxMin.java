package algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxMin {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        int[] list = new int[N];

        for(int i = 0; i < N; i ++)
            list[i] = Integer.parseInt(in.readLine());

        int unfairness = Integer.MAX_VALUE;

        Arrays.sort(list);
        for(int i=0, j=i+K-1; i <= N-K && j <= N-1; i++, j++) {
            int diff = list[j] - list[i];
            if (unfairness > diff) {
                unfairness = diff;
            }
        }

        System.out.println(unfairness);
    }
}
