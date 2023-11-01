package src.programmers.lv1;

import java.util.Arrays;

public class 최대공약수와최소공배수 {
    class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];

            int min = Math.min(n, m);
            int max = Math.max(n, m);

            for (int i = min; i > 0; i--) {
                if (n % i == 0 && m % i == 0) {
                    answer[0] = i;
                    break;
                }
            }

            for (int i = 1; i <= max; i++) {
                if (min * i % max == 0) {
                    answer[1] = min * i;
                    break;
                }
            }

            return answer;
        }
    }

    class TryHelloWorld {
        public int[] gcdlcm(int a, int b) {
            int[] answer = new int[2];

            answer[0] = gcd(a,b);
            answer[1] = (a*b)/answer[0];
            return answer;
        }

        public static int gcd(int p, int q)
        {
            if (q == 0) return p;
            return gcd(q, p%q);
        }
    }
}
