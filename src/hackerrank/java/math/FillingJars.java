package math;

public class FillingJars {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        String[] firstLine = in.nextLine().split("\\s");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);

        long totalCandies = 0;
        for (int i = 0; i < m; i++) {
            String[] secondLine = in.nextLine().split("\\s");
            int a = Integer.valueOf(secondLine[0]);
            int b = Integer.valueOf(secondLine[1]);
            int k = Integer.valueOf(secondLine[2]);

            totalCandies += k * ((long) b - a + 1);
        }
        System.out.println(totalCandies / n);
    }
}