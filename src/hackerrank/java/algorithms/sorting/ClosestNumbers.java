package algorithms.sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] numbers = IntStream.range(0, n).map(i -> in.nextInt()).toArray();

        Arrays.sort(numbers);

        int diff = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int number = numbers[i];
            int currentDiff = numbers[i+1] - number;
            if (diff >= currentDiff) {
                diff = currentDiff;
                List<Integer> pairsWithDiff = cache.get(currentDiff);
                if (pairsWithDiff == null) {
                    pairsWithDiff = new LinkedList<>();
                }
                pairsWithDiff.add(number);
                pairsWithDiff.add(numbers[i+1]);
                cache.put(currentDiff, pairsWithDiff);
            }
        }

        System.out.println(cache.get(diff).stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
