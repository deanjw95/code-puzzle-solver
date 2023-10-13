package src.programmers.lv1;

import java.util.Stack;

public class 약수의개수와덧셈 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i = left; i <= right; i++) {
                boolean isEven = true;
                for (int j = 1; j * j <= i; j++) {
                    if (j * j % i == 0) {
                        isEven = false;
                    }
                }

                if (isEven) {
                    answer += i;
                } else {
                    answer -= i;
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int left, int right) {
            int answer = 0;

            for (int i=left;i<=right;i++) {
                //제곱수인 경우 약수의 개수가 홀수
                if (i % Math.sqrt(i) == 0) {
                    answer -= i;
                }
                //제곱수가 아닌 경우 약수의 개수가 짝수
                else {
                    answer += i;
                }
            }

            return answer;
        }
    }
}
