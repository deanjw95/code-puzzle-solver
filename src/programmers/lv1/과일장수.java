package src.programmers.lv1;

import java.util.Collections;
import java.util.PriorityQueue;

public class 과일장수 {

    class Solution {
        public int solution(int k, int m, int[] score) {
            int answer = 0;

            // int[] 배열을 PriorityQueue<Integer>로 변환
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int value : score) {
                priorityQueue.offer(value);
            }

            int boxCnt = score.length / m;
            for (int i = 0; i < boxCnt; i++) {
                for (int j = 1; j < m; j++) {
                    priorityQueue.poll();
                }
                answer += priorityQueue.poll() * m;
            }

            return answer;
        }
    }

}
