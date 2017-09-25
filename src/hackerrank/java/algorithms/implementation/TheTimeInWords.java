package algorithms.implementation;

import java.util.Scanner;

public class TheTimeInWords {
    private static final String[] HOURS_TO_WORDS = new String[]{
            "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"
    };
    private static final String[] MINUTES_TO_WORDS = new String[]{
            "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int h = Integer.valueOf(in.nextLine());
        int m = Integer.valueOf(in.nextLine());

        System.out.println(toWords(h, m));
    }

    private static String toWords(int h, int m) {
        if (m == 0) {
            return hourToWords(h) + " o' clock";
        } else if (m == 1) {
            return "one minute past " + hourToWords(h);
        } else if (m == 15) {
            return "quarter past " + hourToWords(h);
        } else if (m < 30) {
            return minutesToWords(m) + " past " + hourToWords(h);
        } else if (m == 30) {
            return "half past " + hourToWords(h);
        } else if (m == 45) {
            return "quarter to " + hourToWords(h + 1 % 12);
        } else {
            return minutesToWords(m) + " to " + hourToWords((h + 1) % 12);
        }
    }

    private static String hourToWords(int hour) {
        return HOURS_TO_WORDS[hour];
    }

    private static String minutesToWords(int minute) {
        if (minute < 30) {
            return MINUTES_TO_WORDS[minute - 2] + " minutes";
        } else {
            return MINUTES_TO_WORDS[60 - minute - 2] + " minutes";
        }
    }
}
