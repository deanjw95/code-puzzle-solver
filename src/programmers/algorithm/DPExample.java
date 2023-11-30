package src.programmers.algorithm;

public class DPExample {

    public static int fibonacci(int n) {
        // n이 0이거나 1이면 그대로 반환
        if (n <= 1) {
            return n;
        }

        // DP를 위한 배열 생성
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[0] = 0;
        dp[1] = 1;

        // Bottom-Up 방식으로 피보나치 수열 계산
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 결과 반환
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci(" + n + "): " + fibonacci(n));
    }
}
