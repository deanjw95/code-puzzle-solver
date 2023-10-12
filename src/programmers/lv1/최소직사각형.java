package src.programmers.lv1;

public class 최소직사각형 {

    class Solution {
        public int solution(int[][] sizes) {
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;

            for (int i = 0; i < sizes.length; i++) {
                int[] size = sizes[i];
                if (size[0] < size[1]) {
                    int temp = size[0];
                    size[0] = size[1];
                    size[1] = temp;
                }

                maxX = Math.max(maxX, size[0]);
                maxY = Math.max(maxY, size[1]);
            }

            return maxX * maxY;
        }
    }

    class Solution2 {
        public int solution(int[][] sizes) {
            int length = 0, height = 0;
            for (int[] card : sizes) {
                length = Math.max(length, Math.max(card[0], card[1]));
                height = Math.max(height, Math.min(card[0], card[1]));
            }
            int answer = length * height;
            return answer;
        }
    }
}
