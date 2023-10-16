package src.programmers.lv1;

import java.util.Stack;

public class 음양더하기 {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for (int i = 0; i < absolutes.length; i++) {
                answer = signs[i] ? answer + absolutes[i] : answer - absolutes[i];
            }

            return answer;
        }
    }
}
