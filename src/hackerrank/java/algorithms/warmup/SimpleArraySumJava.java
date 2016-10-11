package algorithms.warmup;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SimpleArraySumJava {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = IntStream.range(0, n).map(i -> in.nextInt()).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
