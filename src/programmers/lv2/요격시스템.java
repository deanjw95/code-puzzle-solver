package src.programmers.lv2;

import java.util.Arrays;

public class 요격시스템 {
    class Solution {
        public int solution(int[][] targets) {
            int answer = 1;
            Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);

            int[] prev = targets[0];

            for (int i = 1; i < targets.length; i++) {
                // 겹치는 경우
                if (prev[1] > targets[i][0]) {
                    continue;
                } else {
                    answer++;
                    prev = targets[i];
                }
            }

            return answer;
        }
    }

    /*
    * 1. y축 기준으로 정렬
    * 2. answer = 1 의 이유는 첫번째 요격시스템은 무조건 쏘아야 하기 때문
    * */
}
