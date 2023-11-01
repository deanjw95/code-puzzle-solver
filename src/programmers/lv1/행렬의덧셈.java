package src.programmers.lv1;

public class 행렬의덧셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr1[0].length];

            for (int i = 0; i < arr1.length; i++) {
                int[] ints = arr1[i];
                for (int j = 0; j < ints.length; j++) {
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            return answer;
        }
    }

    class Solution2go {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = {};
            answer = arr1;
            for(int i=0; i<arr1.length; i++){
                for(int j=0; j<arr1[0].length; j++){
                    answer[i][j] += arr2[i][j];
                }
            }
            return answer;
        }
    }
}
