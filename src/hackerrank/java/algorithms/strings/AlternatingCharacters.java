package algorithms.strings;

import java.util.Scanner;
import java.util.stream.IntStream;

public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.valueOf(in.nextLine());
        IntStream.range(0, t).forEach(test -> {
            String s = in.nextLine();
            countDeletions(s);
        });
    }

    private static void countDeletions(String s) {
        int deletions = 0;
        char lastVisited = 'X';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == lastVisited) {
                deletions++;
            } else {
                lastVisited = c;
            }
        }
        System.out.println(deletions);
    }
}
