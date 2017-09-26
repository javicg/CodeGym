package algorithms;

import java.util.*;

public class GemStones {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());
        String[] rocks = new String[n];
        for (int i = 0; i < n; i++) {
            rocks[i] = in.nextLine();
        }

        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < rocks.length; i++) {
            String rock = rocks[i];
            Set<Character> visited = new HashSet<>();
            for (int j = 0; j < rock.length(); j++) {
                char c = rock.charAt(j);
                if (!visited.contains(c)) {
                    Integer count = cache.get(c);
                    if (count == null) {
                        count = 0;
                    }
                    visited.add(c);
                    cache.put(c, count + 1);
                }
            }
        }

        System.out.println(cache.values().stream().filter(c -> c == n).count());
    }
}
