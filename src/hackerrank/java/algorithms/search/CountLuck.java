package algorithms.search;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CountLuck {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.valueOf(in.nextLine());
        IntStream.range(0, t).forEach(test -> {
            String[] dimensions = in.nextLine().split("\\s");
            int n = Integer.valueOf(dimensions[0]);
            int m = Integer.valueOf(dimensions[1]);

            char[][] forest = new char[n][m];
            boolean[][] visited = new boolean[n][m];
            int mi = 0;
            int mj = 0;
            for (int i = 0; i < n; i++) {
                char[] forestLine = in.nextLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (forestLine[j] == 'M') {
                        mi = i;
                        mj = j;
                    }
                }
                forest[i] = forestLine;
            }

            int k = Integer.valueOf(in.nextLine());
            verifyGuess(forest, visited, mi, mj, k);
        });
    }

    private static void verifyGuess(char[][] forest, boolean[][] visited, int mi, int mj, int k) {
        visited[mi][mj] = true;
        if (forest[mi][mj] == '*') {
            if (k == 0) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int ways = countPossibleWays(forest, visited, mi, mj);
                if (ways > 1) {
                    k--;
                }

                if (canGoNorth(forest, visited, mi, mj)) {
                    verifyGuess(forest, visited, mi-1, mj, k);
                }
                if (canGoEast(forest, visited, mi, mj)) {
                    verifyGuess(forest, visited, mi, mj+1, k);
                }
                if (canGoSouth(forest, visited, mi, mj)) {
                    verifyGuess(forest, visited, mi+1, mj, k);
                }
                if (canGoWest(forest, visited, mi, mj)) {
                    verifyGuess(forest, visited, mi, mj-1, k);
                }
            }
        }
    }

    private static int countPossibleWays(char[][] forest, boolean[][] visited, int mi, int mj) {
        int count = 0;
        if (canGoNorth(forest, visited, mi, mj)) {
            count++;
        }
        if (canGoEast(forest, visited, mi, mj)) {
            count++;
        }
        if (canGoSouth(forest, visited, mi, mj)) {
            count++;
        }
        if (canGoWest(forest, visited, mi, mj)) {
            count++;
        }
        return count;
    }

    private static boolean canGoNorth(char[][] forest, boolean[][] visited, int mi, int mj) {
        return mi - 1 >= 0 && forest[mi-1][mj] != 'X' && !visited[mi-1][mj];
    }

    private static boolean canGoEast(char[][] forest, boolean[][] visited, int mi, int mj) {
        return mj + 1 < forest[mi].length && forest[mi][mj+1] != 'X' && !visited[mi][mj+1];
    }

    private static boolean canGoSouth(char[][] forest, boolean[][] visited, int mi, int mj) {
        return mi + 1 < forest.length && forest[mi+1][mj] != 'X' && !visited[mi+1][mj];
    }

    private static boolean canGoWest(char[][] forest, boolean[][] visited, int mi, int mj) {
        return mj - 1 >= 0 && forest[mi][mj-1] != 'X' && !visited[mi][mj-1];
    }
}
