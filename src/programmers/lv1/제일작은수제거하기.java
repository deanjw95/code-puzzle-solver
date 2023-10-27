package src.programmers.lv1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 제일작은수제거하기 {
    class Solution {
        public int[] solution(int[] arr) {
            if (arr.length == 1) {
                return new int[]{-1};
            } else {
                Arrays.sort(arr);
                return Arrays.copyOfRange(arr, 1, arr.length);
            }
        }
    }

    class Solution2 {
        public int[] solution(int[] arr) {
            if (arr.length <= 1) return new int[]{ -1 };
            int min = Arrays.stream(arr).min().getAsInt();
            return Arrays.stream(arr).filter(i -> i != min).toArray();
        }
    }

}
