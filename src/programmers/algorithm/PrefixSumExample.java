package src.programmers.algorithm;

import java.util.Arrays;

public class PrefixSumExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 누적합 배열 생성 및 초기화
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 특정 구간 합 계산
        int rangeSum = getRangeSum(prefixSum, 2, 4);
        System.out.println("누적합 배열: " + Arrays.toString(prefixSum));
        System.out.println("인덱스 2부터 4까지의 합: " + rangeSum);
    }

    // 특정 구간의 합을 계산하는 함수
    private static int getRangeSum(int[] prefixSum, int a, int b) {
        if (a == 0) {
            return prefixSum[b];
        } else {
            return prefixSum[b] - prefixSum[a - 1];
        }
    }
}

