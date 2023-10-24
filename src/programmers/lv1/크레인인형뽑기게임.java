package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Map<Integer, Stack<Integer>> map = new HashMap<>();

            for (int i = 0; i < board.length; i++) {
                Stack<Integer> stack = new Stack<>();
                for (int j = board[i].length - 1; j >= 0; j--) {
                    if (board[j][i] != 0) {
                        stack.push(board[j][i]);
                    }
                }
                map.put(i, stack);
            }

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < moves.length; i++) {
                int move = moves[i] - 1;
                if (map.get(move).isEmpty()) {
                    continue;
                }
                int doll = map.get(move).pop();
                if (stack.isEmpty()) {
                    stack.push(doll);
                } else {
                    if (stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                }
            }

            return answer;
        }
    }
}
