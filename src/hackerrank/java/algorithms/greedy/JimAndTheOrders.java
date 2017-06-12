package algorithms.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class JimAndTheOrders {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());

        Map<Integer, Set<Integer>> orders = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            String[] pair = in.nextLine().split("\\s");
            int orderTime = Integer.valueOf(pair[0]);
            int cookTime = Integer.valueOf(pair[1]);

            int index = orderTime + cookTime;

            Set<Integer> prev = orders.get(index);
            if (prev == null) {
                prev = new TreeSet<>();
            }
            prev.add(i);
            orders.put(index, prev);
        }

        String output = orders.values().stream()
                .flatMap(Collection::stream)
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        System.out.println(output);
    }
}
