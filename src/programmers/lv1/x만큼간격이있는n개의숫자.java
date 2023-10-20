package src.programmers.lv1;

import java.util.Stack;

public class x만큼간격이있는n개의숫자 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];

            for (int i = 0; i < n; i++) {
                answer[i] = (long) x * (i + 1);
            }

            return answer;
        }
    }
}
