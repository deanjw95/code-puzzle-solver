package src.programmers.lv1;

public class 두정수사이의합 {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            for (int i = a; i <= b; i++) {
                answer += i;
            }
            return answer;
        }
    }

    class Solution2 {

        public long solution(int a, int b) {
            return sumAtoB(Math.min(a, b), Math.max(b, a));
        }

        private long sumAtoB(long a, long b) {
            return (b - a + 1) * (a + b) / 2;
        }
    }
}
