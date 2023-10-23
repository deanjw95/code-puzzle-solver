package src.programmers.lv1;

import java.util.Arrays;

public class 평균구하기 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;
            for (int i = 0; i < arr.length; i++) {
                answer += (double) arr[i];
            }

            answer /= arr.length;
            return answer;
        }
    }

    class Solution2 {
        public double solution(int[] arr) {

            return Arrays.stream(arr).average().getAsDouble();
        }
    }
}
