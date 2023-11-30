package src.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {

    class Position {
        int x;
        int level;

        public Position(int x, int level) {
            this.x = x;
            this.level = level;
        }
    }
    class Solution {
        public int solution(int x, int y, int n) {
            return bfs(x, y, n);
        }

        public int bfs(int currentX, int y, int n) {
            Queue<Position> queue = new LinkedList<>();
            queue.add(new Position(currentX, 0));

            while(!queue.isEmpty()) {
                Position now = queue.poll();
                if (now.x == y) {
                    return now.level;
                }
                now.level++;

                for (int i = 0; i < 3; i++) {
                    int nextX = calculate(now.x, i, n);
                    if (nextX > y) {
                        continue;
                    }
                    queue.add(new Position(nextX, now.level));
                }
            }

            return -1;
        }

        // 0일시 x + n, 1일시 x * 2, 2일시 x * 3인 함수
        public int calculate(int x, int i, int n) {
            switch (i) {
                case 0:
                    return x + n;
                case 1:
                    return x * 2;
                case 2:
                    return x * 3;
                default:
                    throw new IllegalArgumentException("Invalid value for n: " + n);
            }
        }
    }

    public class Solution2 {
        public int solution(int x, int y, int n) {
            int[] dp = new int[y + 1];
            for (int i = x; i < y + 1; i++) {
                if (i != x && dp[i] == 0) {
                    dp[i] = -1;
                    continue;
                }
                if (i * 2 <= y) {
                    dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);
                }
                if (i * 3 <= y) {
                    dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);
                }
                if (i + n <= y) {
                    dp[i + n] = (dp[i + n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);
                }
            }
            return dp[y];
        }
    }


    /*
     * */
}
