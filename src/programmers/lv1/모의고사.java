package src.programmers.lv1;

import java.util.ArrayList;

public class 모의고사 {
    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};

            int[] a = {1, 2, 3, 4, 5};
            int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[] cnt = new int[3];

            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == a[i % a.length]) cnt[0]++;
                if (answers[i] == b[i % b.length]) cnt[1]++;
                if (answers[i] == c[i % c.length]) cnt[2]++;
            }

            int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
            int cnt2 = 0;

            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] == max) cnt2++;
            }

            answer = new int[cnt2];

            int idx = 0;

            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] == max) answer[idx++] = i + 1;
            }

            return answer;
        }
    }

    class Solution2 {
        public int[] solution(int[] answer) {
            int[] a = {1, 2, 3, 4, 5};
            int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int[] score = new int[3];
            for(int i=0; i<answer.length; i++) {
                if(answer[i] == a[i%a.length]) {score[0]++;}
                if(answer[i] == b[i%b.length]) {score[1]++;}
                if(answer[i] == c[i%c.length]) {score[2]++;}
            }
            int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
            ArrayList<Integer> list = new ArrayList<>();
            if(maxScore == score[0]) {list.add(1);}
            if(maxScore == score[1]) {list.add(2);}
            if(maxScore == score[2]) {list.add(3);}
            return list.stream().mapToInt(i->i.intValue()).toArray();
        }
    }
}
