package src.programmers.lv1;

public class 약수의합 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    answer += i;         // 약수를 더함
                    if (i * i != n) {     // 중복되지 않도록 체크
                        answer += n / i;  // 대칭적인 약수를 더함
                    }
                }
            }

            return answer;
        }
    }
}
