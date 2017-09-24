package algorithms.search;

import java.util.*;
import java.util.stream.Collectors;

public class CutTheTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());
        String[] weights = in.nextLine().split("\\s");

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.valueOf(weights[i]);
        }

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String[] nextEdge = in.nextLine().split("\\s");
            int u = Integer.valueOf(nextEdge[0]) - 1;
            int v = Integer.valueOf(nextEdge[1]) - 1;
            connect(tree, u, v);
            connect(tree, v, u);
        }

        Map<Integer, Integer> treeSums = calculateTreeSums(tree, data, n);
        System.out.println(minCut(tree, treeSums, n));
    }

    private static void connect(Map<Integer, List<Integer>> tree, int u, int v) {
        List<Integer> neighbours = tree.get(u);
        if (neighbours == null) {
            neighbours = new LinkedList<>();
        }
        neighbours.add(v);
        tree.put(u, neighbours);
    }

    private static Map<Integer, Integer> calculateTreeSums(Map<Integer, List<Integer>> tree, int[] data, int n) {
        boolean[] visited = new boolean[n];
        int currentVertex = 0;
        Map<Integer, Integer> treeSums = new HashMap<>();
        calculateTreeSums(tree, data, currentVertex, visited, treeSums);
        return treeSums;
    }

    private static void calculateTreeSums(Map<Integer, List<Integer>> tree, int[] data, int currentVertex, boolean[] visited, Map<Integer, Integer> treeSums) {
        visited[currentVertex] = true;
        int partialSum = 0;
        for (Integer neighbour : tree.get(currentVertex)) {
            if (!visited[neighbour]) {
                calculateTreeSums(tree, data, neighbour, visited, treeSums);
                partialSum += treeSums.get(neighbour);
            }
        }
        treeSums.put(currentVertex, partialSum + data[currentVertex]);
    }

    private static int minCut(Map<Integer, List<Integer>> tree, Map<Integer, Integer> treeSums, int n) {
        boolean[] visited = new boolean[n];
        int currentVertex = 0;
        return minCut(tree, treeSums, currentVertex, visited);
    }

    private static int minCut(Map<Integer, List<Integer>> tree, Map<Integer, Integer> treeSums, int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        int minCut = Integer.MAX_VALUE;
        for (Integer neighbour : tree.get(currentVertex)) {
            if (!visited[neighbour]) {
                int currentSumAfterCut = treeSums.get(0) - treeSums.get(neighbour);
                int currentDiff = Math.abs(treeSums.get(neighbour) - currentSumAfterCut);
                int neighbourMinCut = minCut(tree, treeSums, neighbour, visited);
                minCut = Math.min(minCut, Math.min(currentDiff, neighbourMinCut));
            }
        }
        return minCut;
    }
}
