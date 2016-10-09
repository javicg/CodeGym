import java.util.Scanner;

public class CompareTheTripletsJava {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ratingAlice = in.nextLine().split(" ");
        String[] ratingBob = in.nextLine().split(" ");

        int scoreAlice = 0;
        int scoreBob = 0;
        for (int i = 0; i < ratingAlice.length; i++) {
            int rankAlice = Integer.parseInt(ratingAlice[i]);
            int rankBob = Integer.parseInt(ratingBob[i]);
            if (rankAlice > rankBob) {
                scoreAlice++;
            } else if (rankBob > rankAlice) {
                scoreBob++;
            }
        }

        System.out.println(scoreAlice + " " + scoreBob);
    }
}
