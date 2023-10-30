package src.programmers.lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

public class 정수내림차순으로배치하기 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            Queue<Integer> queue = new java.util.PriorityQueue<>(Collections.reverseOrder());

            while (n > 0) {
                queue.add((int) (n % 10));
                n /= 10;
            }

            while (!queue.isEmpty()) {
                answer = answer * 10 + queue.poll();
            }

            return answer;
        }
    }

    class Solution2 {
        public long solution(long n) {
            String[] list = String.valueOf(n).split("");
            Arrays.sort(list);

            StringBuilder sb = new StringBuilder();
            for (String aList : list) sb.append(aList);

            return Long.parseLong(sb.reverse().toString());
        }
    }
}
