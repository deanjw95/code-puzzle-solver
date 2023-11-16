package src.programmers.lv1;

import java.util.Arrays;

public class 폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            int i = nums.length / 2;
            int[] distinctNums = Arrays.stream(nums).distinct().toArray();

            return Math.min(i, distinctNums.length);
        }
    }
}
