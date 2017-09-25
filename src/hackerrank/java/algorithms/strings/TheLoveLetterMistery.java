package algorithms.strings;

import java.util.Scanner;

public class TheLoveLetterMistery {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }

    private static int theLoveLetterMystery(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            int j = s.length() - 1 - i;
            sum += computeDifference(s.charAt(i), s.charAt(j));
        }
        return sum;
    }

    private static int computeDifference(char a, char b) {
        return Math.abs(b - a);
    }
}
