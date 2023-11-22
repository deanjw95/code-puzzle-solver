package src.programmers.lv2;

public class 당구연습 {
    class Solution {
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];

            for (int i = 0; i < balls.length; i++) {
                int[] ball = balls[i];
                int x = ball[0];
                int y = ball[1];

                int v1 = Math.abs(startX - x) > 0 ? (int) (Math.pow(startX - x, 2) + Math.pow(startY + y, 2)) : (int) (Math.pow(n - startY, 2) + Math.pow(startY + y, 2));
                int v2 = Math.abs(startY - y) > 0 ? (int) (Math.pow(startX + x, 2) + Math.pow(startY - y, 2)) : (int) (Math.pow(n - startY, 2) + Math.pow((n - startY) * 2, 2));
                answer[i] = Math.min(v1, v2);
                System.out.println("v1: " + v1 + ", v2: " + v2 + ", answer: " + answer[i]);
            }

            return answer;
        }
    }

    class Solution2 {
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];

            for (int i = 0; i < balls.length; i++) {
                int targetX = balls[i][0];
                int targetY = balls[i][1];

                int curlen, len = Integer.MAX_VALUE;

                // 좌
                if (!(startY == targetY && startX >= targetX)) {
                    curlen = getDistance(startX, startY, targetX * (-1), targetY);
                    len = Math.min(curlen, len);
                }

                // 우
                if (!(startY == targetY && startX <= targetX)) {
                    curlen = getDistance(startX, startY, m + (m - targetX), targetY);
                    len = Math.min(curlen, len);
                }

                // 상
                if (!(startX == targetX && startY <= targetY)) {
                    curlen = getDistance(startX, startY, targetX, n + (n - targetY));
                    len = Math.min(curlen, len);
                }

                // 하
                if (!(startX == targetX && startY >= targetY)) {
                    curlen = getDistance(startX, startY, targetX, targetY * (-1));
                    len = Math.min(curlen, len);
                }

                answer[i] = len;
            }

            return answer;
        }

        public int getDistance(int sx, int sy, int tx, int ty) {
            return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
        }
    }
    /*
    * */
}
