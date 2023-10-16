package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 로또의최고순위와최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = {1, 1};

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < win_nums.length; i++) {
                map.put(win_nums[i], win_nums[i]);
            }

            for (int i = 0; i < lottos.length; i++) {
                if (map.containsKey(lottos[i])) {
                    map.remove(lottos[i]);
                } else if (lottos[i] == 0) {
                    answer[1]++;
                } else {
                    answer[0]++;
                    answer[1]++;
                }

            }

            if (answer[0] == 7) {
                answer[0] = 6;
            }

            if (answer[1] == 7) {
                answer[1] = 6;
            }


            return answer;
        }
    }

}
