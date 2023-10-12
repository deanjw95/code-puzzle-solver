package src.programmers.lv1;

import java.util.List;
import java.util.Stack;

public class 없는숫자더하기 {

    class Solution {
        public int solution(int[] numbers) {

            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < numbers.length; i++) {
                stack.add(numbers[i]);
            }

            for (int i = 0; i < 10; i++) {
                if (stack.contains(i)) {
                    continue;
                } else {
                    answer += i;
                }
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int[] numbers) {
            int sum = 45;
            for (int i : numbers) {
                sum -= i;
            }
            return sum;
        }
    }

}
