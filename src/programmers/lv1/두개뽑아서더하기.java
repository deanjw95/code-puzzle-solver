package src.programmers.lv1;

import java.util.Stack;

public class 두개뽑아서더하기 {
    class Solution {
        public int[] solution(int[] numbers) {
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    stack.push(numbers[i] + numbers[j]);
                }
            }

            return stack.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        }
    }
}
