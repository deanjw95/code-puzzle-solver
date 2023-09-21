package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 바탕화면정리 {

    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = {};

            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;
            int cnt = 0;

            for (int i = 0; i < wallpaper.length; i++) {
                int x = i;
                String split = wallpaper[i];
                // split 안에 있는 모든 #의 index
                for (int j = 0; j < split.length(); j++) {
                    if (split.charAt(j) == '#') {
                        if (cnt == 0) {
                            minX = x;
                            maxX = x + 1;
                            minY = j;
                            maxY = j + 1;
                            cnt++;
                        } else {
                            minX = Math.min(minX, x);
                            maxX = Math.max(maxX, x + 1);
                            minY = Math.min(minY, j);
                            maxY = Math.max(maxY, j + 1);
                        }
                    }
                }
            }
            answer = new int[]{minX, minY, maxX, maxY};
            return answer;
        }
    }

    class Solution2 {
        public int[] solution(String[] wallpaper) {
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            for(int i=0; i< wallpaper.length;i++ ){
                for(int j=0; j<wallpaper[i].length();j++){
                    if(wallpaper[i].charAt(j)=='#'){
                        minX = Math.min(minX,i);
                        minY = Math.min(minY,j);
                        maxX = Math.max(maxX,i);
                        maxY = Math.max(maxY,j);
                    }
                }
            }
            return new int[]{minX,minY,maxX+1,maxY+1};
        }
    }

    /*
    * Integer.MAX_VALUE의 존재를 기억하자!
    * */
}
