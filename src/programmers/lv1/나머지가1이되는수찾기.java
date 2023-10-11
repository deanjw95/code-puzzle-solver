package src.programmers.lv1;

import java.util.Stack;

public class 나머지가1이되는수찾기 {

    class Solution {
        public int solution(int n) {

            for (int i = 1; i < n; i++) {
                if (n % i == 1) {
                    return i;
                }
            }

            int answer = 0;
            return answer;
        }
    }

}
