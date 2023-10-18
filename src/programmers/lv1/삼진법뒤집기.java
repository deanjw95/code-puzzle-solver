package src.programmers.lv1;

import java.util.Stack;

public class 삼진법뒤집기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(n % 3);
            // 3진법으로 변환
            for (int i = 3; i < n; i = i * 3) {
                sb.append(n / i % 3);
            }

            return Integer.parseInt(sb.toString(), 3);
        }
    }

    class Solution2 {
        public int solution(int n) {
            String a = "";

            while(n > 0){
                a = (n % 3) + a;
                n /= 3;
            }
            a = new StringBuilder(a).reverse().toString();


            return Integer.parseInt(a,3);
        }
    }

    // Integer.parseInt에 진수 옵션이 있었다!
}
