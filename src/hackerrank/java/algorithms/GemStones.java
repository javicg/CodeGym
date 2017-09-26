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

        System.out.println(Version2.calculateGemstones(rocks));
    }

    private static class Version2 {
        private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        static long calculateGemstones(String[] rocks) {
            int counter = 0;
            for (char c : ALPHABET) {
                boolean isGemstone = true;
                for (String rock : rocks) {
                    if (!rock.contains("" + c)) {
                        isGemstone = false;
                        break;
                    }
                }
                if (isGemstone) {
                    counter++;
                }
            }
            return counter;
        }
    }

    private static class Version1 {
        static long calculateGemstones(String[] rocks, int n) {
            Map<Character, Integer> cache = new HashMap<>();
            for (String rock : rocks) {
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

            return cache.values().stream().filter(c -> c == n).count();
        }
    }
}
