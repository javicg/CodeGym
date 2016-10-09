import java.util.Scanner;
import java.util.stream.IntStream;

public class AVeryBigSumJava {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum = IntStream.range(0, in.nextInt())
                .mapToLong(i -> in.nextLong())
                .sum();
        System.out.println(sum);
    }
}
