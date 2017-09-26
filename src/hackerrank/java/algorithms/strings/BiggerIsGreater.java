package algorithms.strings;

import java.util.Scanner;

public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.valueOf(in.nextLine());
        for (int i = 0; i < t; i++) {
            String word = in.nextLine();
            System.out.println(findNext(word));
        }
    }

    private static String findNext(String w) {
        char[] word = w.toCharArray();
        int swapIndex = -1;
        int controlIndex = word.length - 2;
        while (controlIndex >= 0 && swapIndex < 0) {
            for (int i = word.length - 1; i >= controlIndex; i--) {
                char ci = word[i];
                char cj = word[controlIndex];
                if (ci > cj) {
                    word[i] = cj;
                    word[controlIndex] = ci;
                    swapIndex = controlIndex;
                    break;
                }
            }
            controlIndex--;
        }

        if (swapIndex < 0) {
            return "no answer";
        }

        for (int i = swapIndex + 1; i < word.length; i++) {
            for (int j = i + 1; j < word.length; j++) {
                char ci = word[i];
                char cj = word[j];
                if (ci > cj) {
                    word[i] = cj;
                    word[j] = ci;
                }
            }
        }

        return new String(word);
    }
}
