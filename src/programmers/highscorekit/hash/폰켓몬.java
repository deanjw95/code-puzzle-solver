package src.programmers.highscorekit.hash;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int max = nums.length / 2;
            return Math.min(map.size(), max);
        }
    }

    /*
    * */
}
