package src.programmers.lv1;

import java.util.Stack;

public class 콜라문제 {

    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            while (n >= a) {
                answer++;
                n = n - a + b;
            }

            return answer;
        }

        public int solution2(int a, int b, int n) {
            int count = 0;
            int num = n;

            while(num >= a) {
                count += num / a * b;
                num = num / a * b + num % a;
            }
            return count;
        }
    }

    class Solution2 {
        public int solution(int a, int b, int n) {
            return (n > b ? n - b : 0) / (a - b) * b;
        }
    }

    // stack을 이용한 방법
}
