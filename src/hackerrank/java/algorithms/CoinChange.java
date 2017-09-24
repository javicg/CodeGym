package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int qty = Integer.valueOf(in.nextLine());
        List<Integer> coins = Arrays.stream(in.nextLine().split("\\s")).map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> change = computeChange(qty, coins);
        System.out.println(change);
    }

    private static List<Integer> computeChange(int qty, List<Integer> coins) {
        return computeChange(qty, 0, coins);
    }

    private static List<Integer> computeChange(int qty, int currentCoinIndex, List<Integer> coins) {
        if (currentCoinIndex >= coins.size()) {
            return new ArrayList<>();
        }

        int currentCoin = coins.get(currentCoinIndex);
        if (qty == currentCoin) {
            List<Integer> change = new ArrayList<>();
            change.add(currentCoin);
            return change;
        } else if (qty < currentCoin) {
            return computeChange(qty, currentCoinIndex + 1, coins);
        } else {
            List<Integer> changeTakingCoin = computeChange(qty - currentCoin, currentCoinIndex + 1, coins);
            changeTakingCoin.add(currentCoin);
            if (changeIsCorrect(changeTakingCoin, qty)) {
                return changeTakingCoin;
            } else {
                List<Integer> changeWithoutTakingCoin = computeChange(qty, currentCoinIndex + 1, coins);
                if (changeIsCorrect(changeWithoutTakingCoin, qty)) {
                    return changeWithoutTakingCoin;
                } else {
                    return new ArrayList<>();
                }
            }
        }
    }

    private static boolean changeIsCorrect(List<Integer> changeTakingCoin, int qty) {
        return changeTakingCoin.stream().mapToInt(c -> c).sum() == qty;
    }
}
