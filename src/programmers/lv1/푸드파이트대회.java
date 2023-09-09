package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 푸드파이트대회 {

    class Solution {
        public String solution(int[] food) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < food.length; i++) {
                if (food[i] > 1) {
                    int temp = food[i] / 2;
                    for (int j = 0; j < temp; j++) {
                        answer.append(i);
                    }
                } else if (food[i] == 1) {
                }
            }
            // 순서가 거꾸로된 answer
            String reverseAnswer = new StringBuilder(answer.toString()).reverse().toString();
            answer.append("0").append(reverseAnswer);

            return answer.toString();
        }
    }

    // StringBuilder와 reverse 메서드를 사용한 풀이

}
