package src.programmers.algorithm;

import java.util.Arrays;

public class GreedyExample {

    // 거스름돈 문제를 해결하는 그리디 알고리즘
    public static void greedyCoinChange(int[] coins, int targetAmount) {
        // 동전을 내림차순으로 정렬
        Arrays.sort(coins);
        int n = coins.length;

        // 거스름돈의 최소 동전 개수를 저장하는 배열
        int[] minCoins = new int[targetAmount + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        // 각 금액에 대해 최소 동전 개수 계산
        for (int amount = 1; amount <= targetAmount; amount++) {
            for (int coin : coins) {
                if (coin <= amount && minCoins[amount - coin] != Integer.MAX_VALUE) {
                    minCoins[amount] = Math.min(minCoins[amount], minCoins[amount - coin] + 1);
                }
            }
        }

        // 결과 출력
        System.out.println("Target Amount: " + targetAmount);
        System.out.println("Minimum Coins: " + (minCoins[targetAmount] == Integer.MAX_VALUE ? "Not possible" : minCoins[targetAmount]));
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25}; // 동전의 단위
        int targetAmount = 63; // 거슬러 줄 금액

        greedyCoinChange(coins, targetAmount);
    }
}