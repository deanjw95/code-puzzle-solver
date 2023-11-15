package src.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 나누어떨어지는숫자배열 {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % divisor == 0) {
                    list.add(arr[i]);
                }
            }

            if (list.isEmpty()) {
                list.add(-1);
            } else {
                list.sort(null);
            }

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    class Divisible {
        public int[] divisible(int[] array, int divisor) {
            return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
        }
    }
}
